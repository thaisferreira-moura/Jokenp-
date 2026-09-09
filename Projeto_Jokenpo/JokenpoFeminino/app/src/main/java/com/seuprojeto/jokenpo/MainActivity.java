package com.seuprojeto.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int placarUsuario = 0;
    private int placarPC = 0;
    private boolean partidaEncerrada = false;

    private TextView txtPlacarUsuario, txtPlacarPC;
    private TextView txtEscolhaUsuario, txtEscolhaPC, txtResultadoRodada, txtVencedorPartida;
    private SwitchMaterial switchMelhorDe3;
    private Button btnPedra, btnPapel, btnTesoura, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapeamento dos componentes
        txtPlacarUsuario = findViewById(R.id.txtPlacarUsuario);
        txtPlacarPC = findViewById(R.id.txtPlacarPC);
        txtEscolhaUsuario = findViewById(R.id.txtEscolhaUsuario);
        txtEscolhaPC = findViewById(R.id.txtEscolhaPC);
        txtResultadoRodada = findViewById(R.id.txtResultadoRodada);
        txtVencedorPartida = findViewById(R.id.txtVencedorPartida);
        switchMelhorDe3 = findViewById(R.id.switchMelhorDe3);
        
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnLimpar = findViewById(R.id.btnLimpar);

        // Ações dos botões
        btnPedra.setOnClickListener(v -> jogar("Pedra"));
        btnPapel.setOnClickListener(v -> jogar("Papel"));
        btnTesoura.setOnClickListener(v -> jogar("Tesoura"));
        
        btnLimpar.setOnClickListener(v -> limparJogo());

        // Ação do Switch (Zerar placar ao alterar modo)
        switchMelhorDe3.setOnCheckedChangeListener((buttonView, isChecked) -> limparJogo());
    }

    private void jogar(String escolhaUsuario) {
        if (partidaEncerrada) {
            return; // Impede novas jogadas se a partida acabou (Melhor de 3)
        }

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaPC = opcoes[new Random().nextInt(3)];

        txtEscolhaUsuario.setText("Sua escolha: " + escolhaUsuario);
        txtEscolhaPC.setText("Computador: " + escolhaPC);

        verificarGanhadorRodada(escolhaUsuario, escolhaPC);
        atualizarPlacar();
        verificarFimDePartida();
    }

    private void verificarGanhadorRodada(String usuario, String pc) {
        if (usuario.equals(pc)) {
            txtResultadoRodada.setText("Empate! Vocês pensaram igual.");
        } else if ((usuario.equals("Pedra") && pc.equals("Tesoura")) ||
                   (usuario.equals("Papel") && pc.equals("Pedra")) ||
                   (usuario.equals("Tesoura") && pc.equals("Papel"))) {
            txtResultadoRodada.setText("Parabéns, você venceu a rodada!");
            placarUsuario++;
        } else {
            txtResultadoRodada.setText("Poxa, o computador venceu essa.");
            placarPC++;
        }
    }

    private void atualizarPlacar() {
        txtPlacarUsuario.setText("Você: " + placarUsuario);
        txtPlacarPC.setText("PC: " + placarPC);
    }

    private void verificarFimDePartida() {
        if (switchMelhorDe3.isChecked()) {
            if (placarUsuario == 2) {
                txtVencedorPartida.setVisibility(View.VISIBLE);
                txtVencedorPartida.setText("Vitória linda! Você ganhou a partida!");
                partidaEncerrada = true;
                desativarBotoesJogada(true);
            } else if (placarPC == 2) {
                txtVencedorPartida.setVisibility(View.VISIBLE);
                txtVencedorPartida.setText("Fim de jogo. O Computador venceu a partida.");
                partidaEncerrada = true;
                desativarBotoesJogada(true);
            }
        }
    }

    private void desativarBotoesJogada(boolean desativar) {
        btnPedra.setEnabled(!desativar);
        btnPapel.setEnabled(!desativar);
        btnTesoura.setEnabled(!desativar);
    }

    private void limparJogo() {
        placarUsuario = 0;
        placarPC = 0;
        partidaEncerrada = false;
        
        atualizarPlacar();
        
        txtEscolhaUsuario.setText("Sua escolha: -");
        txtEscolhaPC.setText("Computador: -");
        txtResultadoRodada.setText("Faça sua escolha para iniciar!");
        
        txtVencedorPartida.setVisibility(View.GONE);
        txtVencedorPartida.setText("");
        
        desativarBotoesJogada(false);
    }
}

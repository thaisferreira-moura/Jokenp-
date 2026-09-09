# Projeto - Jokenpô (Pedra, Papel e Tesoura)

## Sobre o Projeto
Este repositório contém o código-fonte de um aplicativo nativo para Android do clássico jogo Jokenpô (Pedra, Papel e Tesoura). Desenvolvido como requisito da disciplina de Programação de Dispositivos Móveis II, o projeto foi construído inteiramente em Java.

A interface foi desenhada com atenção aos detalhes, adotando uma paleta de cores elegante em tons de rosa e rosê, com elementos arredondados que proporcionam uma experiência de usuário leve, organizada e visualmente agradável.

## Funcionalidades
* **Jogabilidade Dinâmica:** O usuário escolhe entre Pedra, Papel ou Tesoura, e o aplicativo gera uma resposta aleatória e automática para o Computador.
* **Regras Clássicas:** Implementação fiel às regras originais (Pedra vence Tesoura, Tesoura vence Papel, Papel vence Pedra, e opções iguais resultam em empate).
* **Placar em Tempo Real:** Acompanhamento instantâneo das vitórias do Usuário e do Computador de forma clara.
* **Modo Melhor de 3:** Opção interativa (Switch) para ativar partidas disputadas. Ao selecionar este modo, o jogo identifica automaticamente quem atinge 2 vitórias primeiro, declara o grande vencedor da partida e pausa os botões de jogada até o reinício.
* **Botão Limpar:** Reinicia os placares, zera os textos de escolha e prepara a interface para um novo jogo, garantindo fluidez.

## Tecnologias Utilizadas
* Linguagem: Java
* Interface da Aplicação: XML
* Ambiente de Desenvolvimento: Android Studio
* SDK Mínimo: API 24 (Android 7.0)

## Como Compilar e Testar
1. **Clonar o repositório:**
   No seu terminal, execute o comando:
   `git clone [https://github.com/thaisferreira-moura/Jokenp-.git]`

2. **Abrir o projeto:**
   Inicie o Android Studio, selecione "Open" e navegue até a pasta do projeto clonado.

3. **Sincronização e Execução:**
   Aguarde a sincronização automática do Gradle. Para testar, clique no botão "Run" (seta verde) com um emulador ou dispositivo conectado.
   
4. **Gerar Arquivo APK:**
   Para compilar o arquivo final para entrega, vá ao menu superior do Android Studio e selecione:
   `Build > Build Bundle(s) / APK(s) > Build APK(s)`

## Informações Acadêmicas
* **Disciplina:** Programação de Dispositivos Móveis II
* **Desenvolvido por:** [Thais Ferreira de Moura]

# Padrões de Projeto

## Questão I - State
- **Padrão**: State
- **Justificativa**: a classe `BoletimProva` muda de comportamento conforme a fase da prova. O padrão State organiza essas mudanças em objetos separados, facilitando extensão e manutenção.
- **Localização**: diretório `state`.
- **Papéis**:
  - `BoletimProva` - Contexto
  - `FaseProva` - Estado
  - `PreProvaState`, `MomentoLargadaState`, `PistaState`, `PosProvaState` - Implementações de estado

## Questão II - Chain of Responsibility
- **Padrão**: Chain of Responsibility
- **Justificativa**: a apuração da prova envolve várias regras encadeadas que podem variar conforme a configuração. Com o padrão Chain of Responsibility é possível adicionar ou remover regras sem alterar as existentes.
- **Localização**: diretório `chainOfResponsability`.
- **Papéis**:
  - `Apurador` - Configura e inicia a cadeia
  - `RegraApuracao` - Handler abstrato
  - `RegraTempoBase`, `RegraTempoMaximo`, `RegraOrdemPrismas`, `RegraTodosPrismasRegistrados`, `RegraPenalizarAtraso` - Handlers concretos


Questão I - State
Padrão: State

Justificativa: A classe BoletimProva muda de comportamento conforme a fase da prova. O padrão State organiza essas mudanças em objetos separados, facilitando a manutenção e extensão do código. Com isso, evitamos estruturas complexas de if...else ou switch e garantimos que a transição entre as fases da prova seja facilmente extensível, permitindo a inclusão de novas fases sem impactar o código existente.

Localização: diretório state.

Papéis:

BoletimProva - Contexto: mantém o estado atual e delega as operações à fase correspondente.

FaseProva - Estado: interface que define as operações permitidas em cada fase da prova.

PreProvaState, MomentoLargadaState, PistaState, PosProvaState - Implementações de estado: cada uma representa uma fase específica da prova e define o comportamento permitido durante essa fase.

Exemplo de uso:
Durante a prova, o BoletimProva muda de estado conforme o progresso do atleta, como de PreProvaState para MomentoLargadaState, permitindo registrar a largada, e assim por diante até o PosProvaState.

Questão II - Chain of Responsibility
Padrão: Chain of Responsibility

Justificativa: A apuração da prova envolve várias regras encadeadas que podem variar conforme a configuração da prova. O padrão Chain of Responsibility permite que as regras sejam tratadas de forma encadeada e flexível, possibilitando a adição ou remoção de regras sem modificar as existentes. Isso facilita a manutenção e a personalização do processo de apuração para diferentes tipos de provas ou atletas.

Localização: diretório chainOfResponsibility.

Papéis:

Apurador - Configura e inicia a cadeia: organiza a sequência das regras a serem aplicadas.

RegraApuracao - Handler abstrato: define a interface de processamento das regras.

RegraTempoBase, RegraTempoMaximo, RegraOrdemPrismas, RegraTodosPrismasRegistrados, RegraPenalizarAtraso - Handlers concretos: implementam as regras específicas de apuração.

Exemplo de uso:
A classe Apurador configura a sequência de regras de apuração, e, ao chamar o método apurar(), as regras são executadas uma a uma, validando os dados do boletim de acordo com as exigências da prova.


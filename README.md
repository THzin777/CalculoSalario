 App Calculadora de Salário

Aplicativo Android feito em Java que permite o cadastro e login de usuário e faz o cálculo do salário líquido, considerando descontos de INSS e IR, além do salário-família quando o funcionário tem filhos.

 Funcionalidades

Cadastro simples com nome, e-mail e senha (armazenado localmente).

Login local (sem banco de dados, apenas autenticação em memória).

Tela de cálculo com entrada de dados:

Nome do funcionário

Salário bruto

Sexo (Masculino ou Feminino)

Número de filhos

Cálculo automático de:

Desconto de INSS

Desconto de Imposto de Renda (IR)

Salário-família (se aplicável)

Salário líquido final

Tecnologias usadas

Linguagem: Java

IDE: Android Studio

Layout: ConstraintLayout (XML)

SDK mínima: 21

Build: Gradle

 Regras de cálculo
INSS
Faixa de Salário (R$)	Taxa (%)
até 1.212,00	7,5%
1.212,01 a 2.427,35	9%
2.427,36 a 3.641,03	12%
3.641,04 a 7.087,22	14%
IR (Imposto de Renda)
Faixa de Salário (R$)	Taxa (%)
até 1.903,98	Isento
1.903,99 a 2.826,65	7,5%
2.826,66 a 3.751,05	15%
3.751,06 a 4.664,68	22,5%
Salário-Família

Até R$ 1.212,00 → R$ 56,47 por filho

Acima de R$ 1.212,00 → não recebe

Exemplo de cálculo

Entrada:
Salário Bruto = R$ 1.000,00
Sexo = Masculino
Filhos = 2

Resultado:
INSS: R$ 75,00
IR: R$ 0,00
Salário-Família: R$ 112,94
Salário Líquido: R$ 1.037,94

 Como executar

Abra o projeto no Android Studio.

Clique em Run  para instalar o app no emulador ou celular.

Faça o cadastro e depois o login.

Vá até a tela Calculadora e insira os dados para ver o resultado.

 Estrutura do projeto
app/
 ├── java/
 │   └── com.example.calculadorasalario/
 │       ├── MainActivity.java
 │       ├── CadastroActivity.java
 │       ├── CalculadoraActivity.java
 │       └── Usuario.java
 └── res/
     ├── layout/
     │   ├── activity_main.xml
     │   ├── activity_cadastro.xml
     │   └── activity_calculadora.xml
     └── values/
         └── strings.xml

 Autor

Projeto desenvolvido por Arthur Santana Rodrigues Castilhos

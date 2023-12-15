import java.util.ArrayList;

interface Alimentavel {
  void alimentar(double kg);
}

interface Sonoro {
  void emitirSom();
}

interface Exibivel {
  void exibirEstado();
}

class Animal implements Alimentavel, Sonoro, Exibivel {
  int identificador;

  double peso;
   public double getPeso(){
    return this.peso;
  }

  public void setPeso(double peso){
    this.peso = peso;
  }

  int idade;

  private String tipo = "Animal";

  public String getTipo() {
    return tipo;
  }

  @Override
  public void alimentar(double kg) {
    System.out.println(String.format("%s foi alimentado com %.0fkg de alimento.", this.getTipo(), kg));
    this.setPeso(this.getPeso() + kg);
  }

  private String som;

  public String getSom() {
    return som;
  }

  @Override
  public void emitirSom() {
    System.out.println(String.format("O animal fez %s.", this.getSom()));
    // Implementação do som comum a todos os animais
  }

  @Override
  public void exibirEstado() {
    // Implementação da exibição do estado comum a todos os animais
    System.out.println(String.format("O peso do animal é: %.2f ", this.getPeso()));
  }

  public double calcularPreco() {
    // Implementação do cálculo do preço comum a todos os animais
    return 0.0;
  }
}

class Gado extends Animal {
  private String tipo = "Gado";
  public double peso = 450.0d;

  public String getTipo() {
    return tipo;
  }

  private String som = "Muuuh";

  @Override
  public String getSom() {
    return this.som;
  }

  @Override
  public double getPeso(){
    return this.peso;
  }

  @Override
  public void setPeso(double peso) {
    this.peso = peso;
  }
}

class Porco extends Animal {
  // Atributos específicos para porco
  // Construtor e métodos específicos para porco
  private String tipo = "Porco";

  public String getTipo() {
    return tipo;
  }

  private String som = "Honc";

  @Override
  public String getSom() {
    return this.som;
  }
}

class VacaLeiteira extends Animal {
  // Atributos específicos para vaca leiteira
  // Construtor e métodos específicos para vaca leiteira
  private String tipo = "Vaca Leiteira";

  public String getTipo() {
    return tipo;
  }

  private String som = "Muuuh";

  @Override
  public String getSom() {
    return this.som;
  }
}

class Funcionario {
  // Atributos comuns a todos os funcionários
  String nome;
  int idade;
  String CPF;
  double salarioBase;

  // Construtor e métodos comuns a todos os funcionários

  public double calcularSalario() {
    // Implementação do cálculo do salário comum a todos os funcionários
    return salarioBase;
  }

  public void exibirEstado() {
    // Implementação da exibição do estado comum a todos os funcionários
  }
}

class Tratador extends Funcionario {
  // Atributos específicos para tratador
  // Construtor e métodos específicos para tratador
}

class ExtratorLeite extends Funcionario {
  // Atributos específicos para extrator de leite
  // Construtor e métodos específicos para extrator de leite
}

class Gerente extends Funcionario {
  // Atributos específicos para gerente
  // Construtor e métodos específicos para gerente
}

class Fazenda {
  // Atributos da fazenda
  String nome;
  double dimensao;
  String localizacao;
  ArrayList<Animal> listaAnimais;
  ArrayList<Funcionario> listaFuncionarios;
  double valorArrecadado;

  // Construtor e métodos da fazenda
  public static void main(String[] args) {
    Gado gado = new Gado();
    gado.emitirSom();
    gado.exibirEstado();
    gado.alimentar(20); // comeu 20kg de alimento
    gado.exibirEstado();
    gado.alimentar(5); // comeu 5kg de alimento
    gado.exibirEstado();
    gado.alimentar(12);// comeu 12kg de alimento
    gado.exibirEstado();
  }

  public void adicionarAnimal(Animal animal) {
    // Implementação para adicionar um animal à fazenda
  }

  public void removerAnimal(Animal animal) {
    // Implementação para remover um animal da fazenda
  }

  public void adicionarFuncionario(Funcionario funcionario) {
    // Implementação para adicionar um funcionário à fazenda
  }

  public void removerFuncionario(Funcionario funcionario) {
    // Implementação para remover um funcionário da fazenda
  }

  public double calcularFolhaPagamento() {
    // Implementação para calcular a folha de pagamento
    return 0.0;
  }

  public double calcularSituacaoFinanceira() {
    // Implementação para calcular a situação financeira
    return 0.0;
  }

  public void gerarRelatorio() {
    // Implementação para gerar relatório
  }

  // Outros métodos necessários
}

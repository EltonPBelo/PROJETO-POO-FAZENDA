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
  public int getIdade(){
    return this.idade;
  }

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
    System.out.println(String.format("O peso do animal é: %.0fkg", this.getPeso()));
    System.out.println(String.format("A idade do animal é: %d anos", this.getIdade()));
    System.out.println(String.format("O preço do animal é: R$%.1f", this.calcularPreco()));

  }

  public double calcularPreco() {
    // Implementação do cálculo do preço comum a todos os animais
  
    return 0.0;
  }
}

class Gado extends Animal {
  private String tipo = "Gado";
  public String getTipo() {
    return tipo;
  }

  public int idade = 0; // Animal nasceu a pouco tempo.
  @Override
  public int getIdade() {
    return this.idade;
  }

  private String som = "Muuuh";
  @Override
  public String getSom() {
    return this.som;
  }

  public double peso = 450.0d;
  @Override
  public double getPeso(){
    return this.peso;
  }

  @Override
  public void setPeso(double peso) {
    this.peso = peso;
  }

  public int arroba = 250;
  @Override
  public double calcularPreco() {
    final double arroba = this.getPeso() / 15;
    final double preco  = arroba * this.arroba;
    return preco;
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

class Abate {
  public double receita;
  public double peso;
  public String tipo;
  public Abate(
    double receita,
    double peso,
    String tipo
  ){
    this.receita = receita;
    this.peso = peso;
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return String.format("O animal %s foi abatido com o peso %.0fkg e gerou a receita de R$%.0f", this.tipo, this.peso, this.receita);
  }
}

class Fazenda {
  // Atributos da fazenda
  String nome;
  double dimensao;
  String localizacao;
  ArrayList<Animal> listaAnimais ;
  ArrayList<Funcionario> listaFuncionarios;
  ArrayList<Abate> listaAbates;
  double valorArrecadado;

  // Construtor e métodos da fazenda
  public Fazenda(){
    this.listaAnimais = new ArrayList<Animal>();
    this.listaAbates = new ArrayList<Abate>();
  }

  public static void main(String[] args) {
    Fazenda fazenda = new Fazenda();
    Gado gado = new Gado();
    Gado gado_2 = new Gado();

    fazenda.adicionarAnimal(gado);

    gado.alimentar(300);
    gado_2.alimentar(500);

    fazenda.abaterAnimal(gado);
    fazenda.abaterAnimal(gado_2); // não será possivel pois o animal não está na fazenda

    fazenda.gerarRelatorio();
  }

  public void adicionarAnimal(Animal animal) {
    this.listaAnimais.add(animal);

    System.out.println(String.format("O animal %s foi adicionado a fazenda", animal.getTipo()));
    // Implementação para adicionar um animal à fazenda
  }


  public void abaterAnimal(Animal animal){
    final int abate;
    final double lucro;

    if (!this.listaAnimais.contains(animal)){ //verificação se o animal está na fazenda caso não esteja o sitema é bloqueado.
      System.out.println(String.format("O animal %s não está presente na fazenda", animal.getTipo()));
      return;
    }

    if (animal.getTipo().toLowerCase() ==  "porco"){
      abate = 400; //ex
    } else {
      abate = 700;
    }

    if (animal.getPeso() >= abate){
      System.out.println(String.format("O animal %s foi abatido com o peso de %.0fkg", animal.getTipo(), animal.getPeso()));
      lucro = animal.calcularPreco();
      System.out.println(String.format("A fazenda obeteve um lucro de R$%.2f", lucro));
      Abate abate_ = new Abate(lucro, animal.getPeso(), animal.getTipo());
      this.listaAbates.add(abate_);
      this.listaAnimais.remove(animal);

      // adicionar o lucro a folha de pagamento

    } else {
        System.out.println(String.format("O animal %s não cumpre os requisitos para ser abatido", animal.getTipo()));
    }

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
    System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println(" - Relatorio da Fazenda");
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println(String.format("Abates totais: %d\n", this.listaAbates.size()));
    String pre_relatorio = "";
    for (Abate e : this.listaAbates){
      pre_relatorio += e.toString() + "\n";
      // nesse for, vocês tem acesso a todos os abates da fazenda
      // nessa varivel pre_relatorio nela contem as informações de todos os abates da fazenda ai só colocar o valor dela no arquivo txt. 
    }

    System.out.println("Mais informações:");
    System.out.println(pre_relatorio);
  }

  // Outros métodos necessários
}

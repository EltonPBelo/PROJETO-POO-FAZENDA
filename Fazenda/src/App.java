import java.util.ArrayList;

interface Alimentavel {
    void alimentar();
}

interface Sonoro {
    void emitirSom();
}

interface Exibivel {
    void exibirEstado();
}

class Animal implements Alimentavel, Sonoro, Exibivel {
    // Atributos comuns a todos os animais
    int identificador;
    double peso;
    int idade;

    // Construtor e métodos comuns a todos os animais

    @Override
    public void alimentar() {
        // Implementação da alimentação comum a todos os animais
    }

    @Override
    public void emitirSom() {
        // Implementação do som comum a todos os animais
    }

    @Override
    public void exibirEstado() {
        // Implementação da exibição do estado comum a todos os animais
    }

    public double calcularPreco() {
        // Implementação do cálculo do preço comum a todos os animais
        return 0.0;
    }
}

class Gado extends Animal {
    // Atributos específicos para gado
    // Construtor e métodos específicos para gado
}

class Porco extends Animal {
    // Atributos específicos para porco
    // Construtor e métodos específicos para porco
}

class VacaLeiteira extends Animal {
    // Atributos específicos para vaca leiteira
    // Construtor e métodos específicos para vaca leiteira
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
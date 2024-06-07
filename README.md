# RH Revolution
O RH Revolution tem como objetivo de ser um sistema prático e objetivo para cadastro e gerenciamento de funcionários.

## Tabela de conteúdos
1. Instalação
2. Uso
3. Funcionalidades
4. Contribuição
5. Contato

## Instalação
Clonar o repositório:
git clone https://github.com/AAndreLuis-dev/RHRevolution.git

Navegar até o diretório do projeto:
cd RHRevolution

Instalar dependências:
npm install

## Uso

Exemplos:

1.
```
// Método toString que retorna uma string formatada com o nome, email e CPF do funcionário
    public String toString(int numero) {
        return String.format("\nNome: %s"
                + "\nemail: %s"
                + "\nCPF: %s", this.nome, this.email, this.cpf);
    }
```


2.
```
// Método toString que retorna uma string formatada com todos os atributos do funcionário
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return String.format("\nID: %d"
                + "\nNome: %s"
                + "\nemail: %s"
                + "\nsalario: %.2f"
                + "\nCPF: %s"
                + "\nMeses Trabalhado: %d"
                + "\nData contratado: %s", this.id, this.nome, this.email, this.salario, this.cpf, getMesesTrabalho(), this.dataContratado.format(formatter));
    }
```
## Funcionalidades
Exemplos:
1. Cadastro prévio de funcionários:
```
LocalDate dataBase = LocalDate.of(1992, 1, 1);
        FuncionarioServices.cadastroUsuario(new Funcionario("Rodson", "Rodzinho@gmail.com", 800, "123123-23", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Lou", "clarinha@gmail.com", 750, "90312344-21", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Gabriel", "gaybrielhackerzin@gmail.com", 1300, "7233573-67", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Catarina", "catcatgoth@gmail.com", 750, "85123051-13", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Alice", "miawmiawUwU@gmail.com", 600, "75772343-65", dataBase));
```
2. Cadastro de funcionario no departamento
```
        DepartamentoServices.cadastrarFuncionario("TI", "75772343-65" );
        DepartamentoServices.cadastrarFuncionario("TI", "85123051-13" );
        DepartamentoServices.cadastrarFuncionario("Geral", "123123-23");
```
## Contribuição
Queremos tornar este projeto melhor e mais útil para todos, então contribuições são bem-vindas! Aqui estão algumas maneiras de você ajudar:


Se você encontrar um problema, por favor, relate-o usando o sistema de issues. Antes de abrir uma nova issue, verifique se o problema já não foi relatado.

Contribuições em forma de código são altamente apreciadas! Aqui está um guia rápido:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (git checkout -b feature/sua-feature).
3. Commit suas mudanças (git commit -am 'Adicionei uma nova feature').
4. Push para a branch (git push origin feature/sua-feature).
5. Abra um Pull Request explicando suas mudanças.


Sinta-se à vontade para sugerir melhorias.

## Contato
André Luis - andreluis@gmail.com

Link do Projeto: https://github.com/AAndreLuis-dev/RHRevolution/tree/master


package com.alexjr.gestaofuncionarios;

import com.alexjr.gestaofuncionarios.model.Funcionario;
import com.alexjr.gestaofuncionarios.service.FuncionarioService;
import com.alexjr.gestaofuncionarios.util.FormatadorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Principal {

    private final List<Funcionario> funcionarios;
    private final FuncionarioService service;

    public Principal() {
        this.funcionarios = new ArrayList<>();
        this.service = new FuncionarioService(funcionarios);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.execute();
    }

    public void execute() {
        // 3.1 - Inserir todos os funcionários conforme tabela
        cadastrarFuncionarios();

        // 3.2 - Remover o funcionário "João"
        removerJoao();

        // 3.3 - Imprimir todos os funcionários com formatação
        imprimirFuncionarios();

        // 3.4 - Aplicar aumento de 10% nos salários
        aplicarAumento();

        // 3.5 e 3.6 - Agrupar funcionários por função e imprimir
        agruparPorFuncao();

        // 3.8 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
        imprimirAniversariantes();

        // 3.9 - Imprimir o funcionário com maior idade
        imprimirFuncionarioMaisVelho();

        // 3.10 - Imprimir funcionários em ordem alfabética
        imprimirOrdemAlfabetica();

        // 3.11 - Imprimir o total dos salários
        imprimirTotalSalarios();

        // 3.12 - Imprimir quantos salários mínimos cada funcionário ganha
        imprimirSalariosMinimos();
    }
    private void cadastrarFuncionarios() {
        service.adicionarFuncionario(new Funcionario(1L, "Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        service.adicionarFuncionario(new Funcionario(2L, "João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        service.adicionarFuncionario(new Funcionario(3L, "Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        service.adicionarFuncionario(new Funcionario(4L, "Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        service.adicionarFuncionario(new Funcionario(5L, "Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        service.adicionarFuncionario(new Funcionario(6L, "Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        service.adicionarFuncionario(new Funcionario(7L, "Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        service.adicionarFuncionario(new Funcionario(8L, "Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        service.adicionarFuncionario(new Funcionario(9L, "Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        service.adicionarFuncionario(new Funcionario(10L, "Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    private void removerJoao() {
        System.out.println("=== 3.2 Remover João ===");
        service.removerFuncionarioPorId(2L);
    }

    private void imprimirFuncionarios() {
        System.out.println("\n=== 3.3 Imprimir funcionários ===");
        for (Funcionario funcionario : service.listarFuncionarios()) {
            imprimirFuncionario(funcionario);
        }
    }

    private void aplicarAumento() {
        System.out.println("\n=== 3.4 Aplicar aumento de 10% ===");
        service.aplicarAumentoDeDezPorCento();

        for (Funcionario funcionario : service.listarFuncionarios()) {
            imprimirFuncionario(funcionario);
        }
    }

    private void agruparPorFuncao() {
        System.out.println("\n=== 3.5 e 3.6 Agrupar por função ===");

        Map<String, List<Funcionario>> funcionariosPorFuncao = service.agruparPorFuncao();

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                imprimirFuncionario(funcionario);
            }
        }
    }

    private void imprimirAniversariantes() {
        System.out.println("\n=== 3.8 Aniversariantes dos meses 10 e 12 ===");

        for (Funcionario funcionario : service.buscarAniversariantesMes10e12()) {
            imprimirFuncionario(funcionario);
        }
    }

    private void imprimirFuncionarioMaisVelho() {
        System.out.println("\n=== 3.9 Funcionário mais velho ===");

        Funcionario funcionario = service.buscarFuncionarioMaisVelho();

        if (funcionario != null) {
            int idade = service.calcularIdade(funcionario);
            System.out.println(funcionario.getNome() + " - " + idade + " anos");
        }
    }

    private void imprimirOrdemAlfabetica() {
        System.out.println("\n=== 3.10 Ordem alfabética ===");

        for (Funcionario funcionario : service.listarFuncionariosEmOrdemAlfabetica()) {
            imprimirFuncionario(funcionario);
        }
    }

    private void imprimirTotalSalarios() {
        System.out.println("\n=== 3.11 Total dos salários ===");
        System.out.println(FormatadorUtil.formatarSalario(service.calcularTotalSalarios()));
    }

    private void imprimirSalariosMinimos() {
        System.out.println("\n=== 3.12 Salários mínimos por funcionário ===");

        for (Funcionario funcionario : service.listarFuncionarios()) {
            System.out.println(
                    funcionario.getNome() + ": " +
                            FormatadorUtil.formatarNumero(service.calcularSalariosMinimos(funcionario))
            );
        }
    }

    private void imprimirFuncionario(Funcionario funcionario) {
        System.out.println(
                funcionario.getId() + " | " +
                        funcionario.getNome() + " | " +
                        FormatadorUtil.formatarData(funcionario.getDataNascimento()) + " | " +
                        FormatadorUtil.formatarSalario(funcionario.getSalario()) + " | " +
                        funcionario.getFuncao()
        );
    }
}
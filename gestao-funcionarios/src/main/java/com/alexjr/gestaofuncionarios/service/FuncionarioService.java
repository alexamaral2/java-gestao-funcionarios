package com.alexjr.gestaofuncionarios.service;

import com.alexjr.gestaofuncionarios.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FuncionarioService {

    private final List<Funcionario> funcionarios;
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public FuncionarioService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarios.stream()
                .filter(funcionario -> Objects.equals(funcionario.getId(), id))
                .findFirst();
    }

    public boolean removerFuncionarioPorId(Long id) {
        return buscarPorId(id)
                .map(funcionarios::remove)
                .orElse(false);
    }

    public void aplicarAumentoDeDezPorCento() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            BigDecimal novoSalario = funcionario.getSalario()
                    .add(aumento)
                    .setScale(2, RoundingMode.HALF_UP);

            funcionario.setSalario(novoSalario);
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();

            if (!mapa.containsKey(funcao)) {
                mapa.put(funcao, new ArrayList<>());
            }

            mapa.get(funcao).add(funcionario);
        }

        return mapa;
    }

    public List<Funcionario> buscarAniversariantesMes10e12() {
        List<Funcionario> resultado = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            int mes = funcionario.getDataNascimento().getMonthValue();

            if (mes == 10 || mes == 12) {
                resultado.add(funcionario);
            }
        }

        return resultado;
    }

    public Funcionario buscarFuncionarioMaisVelho() {
        if (funcionarios.isEmpty()) {
            return null;
        }

        Funcionario maisVelho = funcionarios.getFirst();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionario;
            }
        }

        return maisVelho;
    }

    public List<Funcionario> listarFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> listaOrdenada = new ArrayList<>(funcionarios);
        listaOrdenada.sort(Comparator.comparing(Funcionario::getNome));
        return listaOrdenada;
    }

    public BigDecimal calcularTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            total = total.add(funcionario.getSalario());
        }

        return total;
    }

    public BigDecimal calcularSalariosMinimos(Funcionario funcionario) {
        BigDecimal salario = funcionario.getSalario();
        return salario.divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
    }

    public int calcularIdade(Funcionario funcionario) {
        return Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
    }
}
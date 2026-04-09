package com.alexjr.gestaofuncionarios.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatadorUtil {

    private static final Locale LOCALE_BR = new Locale("pt", "BR");
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatarData(LocalDate data) {
        return data.format(FORMATADOR_DATA);
    }

    public static String formatarSalario(BigDecimal salario) {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(LOCALE_BR);
        return formatadorMoeda.format(salario);
    }

    public static String formatarNumero(BigDecimal valor) {
        return String.format("%.2f", valor);
    }
}
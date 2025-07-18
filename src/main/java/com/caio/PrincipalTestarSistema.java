package com.caio;

import com.caio.exception.*;
import com.caio.model.*;
import com.caio.service.*;

import java.util.List;

public class PrincipalTestarSistema {

    private final PedidoService pedidoService = new PedidoService();

    private final ClienteService clienteService = new ClienteService();

    private final LivroService livroService = new LivroService();

    private final FaturaService faturaService = new FaturaService();

    public void principal() {

        Cliente cliente_1, cliente_2;
        String dataEmissao_fevereiro28 = "28/02/2025/00:00:00", dataCancelamento = "06/01/2025/00:00:00";
        Livro livro_1, livro_2, livro_3, livro_4, livro_5;
        Pedido pedido1, pedido2, pedido3, pedido4, pedido5;
        ItemDePedido umItemDePedido;
        List<Livro> livros;
        int idFatura_1 = 1, idFatura_2 = 2, idFatura_3 = 3, idFatura_4 = 4, idFatura_5 = 5;

        System.out.println('\n' + "========================================================");
        System.out.println('\n' + "Iniciando Teste...");
        System.out.println('\n' + "========================================================\n");

        System.out.println("1) Cadastrando 5 livros...\n");

        livro_1 = new Livro ("10", "Aaa", "Aaaa", 10, 100);
        livro_2 = new Livro("20", "Bbb", "Bbbb", 20, 200);
        livro_3 = new Livro("30", "Ccc", "Cccc", 30, 300);
        livro_4 = new Livro("40", "Ddd", "Dddd", 40, 400);
        livro_5 = new Livro("50", "Eee", "Eeee", 50, 500);

        livroService.incluir(livro_1);
        livroService.incluir(livro_2);
        livroService.incluir(livro_3);
        livroService.incluir(livro_4);
        livroService.incluir(livro_5);
        livros = livroService.recuperarLivros();

        System.out.println("2) Listando os livros...");
        try {
            livroService.listarLivros(livros);
        } catch (SemLivrosException e) {
            System.out.println('\n' + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("3) Cadastrando 2 clientes...\n");

        cliente_1 = new Cliente("111", "Xxxx", "xxxx@gmail.com", "11111111");
        cliente_2 = new Cliente("222", "Yyyy", "yyyy@gmail.com", "22222222");

        clienteService.incluir(cliente_1);
        clienteService.incluir(cliente_2);

        System.out.println("4/5) Cadastrando e Listando 5 pedidos...");

        // 4) Cadastrar 5 pedidos
        pedido1 = new Pedido("01/01/2025/23:00:00", cliente_1);
        pedido1.setStatus("Não faturado");
        umItemDePedido = new ItemDePedido(5, 5, livro_1.getPreco(), livro_1, pedido1);
        pedido1.getItemDePedidos().add(umItemDePedido);
        livro_1.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(15, 15, livro_2.getPreco(), livro_2, pedido1);
        pedido1.getItemDePedidos().add(umItemDePedido);
        livro_2.getItemDePedidos().add(umItemDePedido);
        pedidoService.incluir(pedido1);


        pedido2 = new Pedido("02/01/2025/23:00:00", cliente_1);
        pedido2.setStatus("Não faturado");
        umItemDePedido = new ItemDePedido(10, 10, livro_1.getPreco(), livro_1, pedido2);
        pedido2.getItemDePedidos().add(umItemDePedido);
        livro_1.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(40, 40, livro_3.getPreco(), livro_3, pedido2);
        pedido2.getItemDePedidos().add(umItemDePedido);
        livro_3.getItemDePedidos().add(umItemDePedido);
        pedidoService.incluir(pedido2);


        pedido3 = new Pedido("03/01/2025/23:00:00", cliente_1);
        pedido3.setStatus("Não faturado");
        umItemDePedido = new ItemDePedido(5, 5, livro_1.getPreco(), livro_1, pedido3);
        pedido3.getItemDePedidos().add(umItemDePedido);
        livro_1.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(10, 10, livro_3.getPreco(), livro_3, pedido3);
        pedido3.getItemDePedidos().add(umItemDePedido);
        livro_3.getItemDePedidos().add(umItemDePedido);
        pedidoService.incluir(pedido3);


        pedido4 = new Pedido("04/01/2025/23:59:00", cliente_1);
        pedido4.setStatus("Não faturado");
        umItemDePedido = new ItemDePedido(10, 10, livro_2.getPreco(), livro_2, pedido4);
        pedido4.getItemDePedidos().add(umItemDePedido);
        livro_2.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(10, 10, livro_3.getPreco(), livro_3, pedido4);
        pedido4.getItemDePedidos().add(umItemDePedido);
        livro_3.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(10, 10, livro_4.getPreco(), livro_4, pedido4);
        pedido4.getItemDePedidos().add(umItemDePedido);
        livro_4.getItemDePedidos().add(umItemDePedido);
        pedidoService.incluir(pedido4);


        pedido5 = new Pedido("05/01/2025/23:59:00", cliente_1);
        pedido5.setStatus("Não faturado");
        umItemDePedido = new ItemDePedido(5, 5, livro_2.getPreco(), livro_2, pedido5);
        pedido5.getItemDePedidos().add(umItemDePedido);
        livro_2.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(5, 5, livro_3.getPreco(), livro_3, pedido5);
        pedido5.getItemDePedidos().add(umItemDePedido);
        livro_3.getItemDePedidos().add(umItemDePedido);

        umItemDePedido = new ItemDePedido(5, 5, livro_4.getPreco(), livro_4, pedido5);
        pedido5.getItemDePedidos().add(umItemDePedido);
        livro_4.getItemDePedidos().add(umItemDePedido);
        pedidoService.incluir(pedido5);

        pedidoService.listarTodosOsPedidos(pedidoService.recuperarPedidos());
        System.out.println("\n");

        System.out.println("6) Listando os livros...\n");
        try {
            livroService.listarLivros(livros);
        } catch (SemLivrosException e) {
            System.out.println('\n' + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("7) Faturando os pedidos 1 e 2, nesta ordem, para o mês de janeiro de 2025...");

        try{
            faturaService.faturarPedido(cliente_1, pedido1, "10/01/2025/00:00:00");
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido2, "10/01/2025/00:00:00");
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        System.out.println("8) Cancelando a Fatura 2...");
        try{
            Fatura umaFatura = faturaService.recuperarFaturaPorId(idFatura_2);
            faturaService.cancelarFatura(cliente_1, umaFatura, dataCancelamento);
        } catch(ClienteSemFaturaException | EntidadeNaoEncontradaException | FaturaCanceladaException |
                ClienteComNumeroInsuficienteDeFaturasException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        System.out.println("9) Faturando os pedidos 3 e 4, nesta ordem, para o mês de janeiro de 2025...");
        try{
            faturaService.faturarPedido(cliente_1, pedido3, "20/01/2025/00:00:00");
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido4, "20/01/2025/00:00:00");
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");


        System.out.println("10) Faturando o pedido 5 para o mês de fevereiro de 2025...");
        try{
            faturaService.faturarPedido(cliente_1, pedido5, "28/02/2025/00:00:00");
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n");

        System.out.println("11) Listando todos os livros...");
        try {
            livroService.listarLivros(livros);
        } catch (SemLivrosException e) {
            System.out.println('\n' + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("12) Listando todas as faturas...");
        try {
            faturaService.listarFaturasFormatado(cliente_1.getFaturas());
        } catch (ClienteSemFaturaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("13) Cancelando o pedido 5 para o dia 28/02/2025...");
        try{
            pedidoService.cancelarPedido(cliente_1, pedido5, "28/02/2025/00:00:00");
        } catch(ClienteSemPedidosException | PedidoCanceladoException | PedidoFaturadoException |
                ImpossivelCancelarPedidoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        System.out.println("14) Cancelando a fatura 3 para o dia 06/01/2025...");
        try{
            faturaService.cancelarFatura(cliente_1, faturaService.recuperarFaturaPorId(3), dataCancelamento);
        } catch(ClienteSemFaturaException | EntidadeNaoEncontradaException | FaturaCanceladaException |
                ClienteComNumeroInsuficienteDeFaturasException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");

        System.out.println("15) Removendo a fatura 3...");
        try {
            faturaService.remover(idFatura_3, cliente_1);
        } catch (EntidadeNaoEncontradaException | FaturaCanceladaException | ClienteSemFaturaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        System.out.println("16) Removendo a fatura 4...");
        try {
            faturaService.remover(idFatura_4, cliente_1);
        } catch (EntidadeNaoEncontradaException | FaturaCanceladaException | ClienteSemFaturaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");

        System.out.println("17) Listando todos os livros...");
        try {
            livroService.listarLivros(livros);
        } catch (SemLivrosException e) {
            System.out.println('\n' + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("18) Abastecendo o estoque...");
        livroService.AbastecerEstoqueDeTodosOsLivrosDadoUmaQuantidade(livros, 100);
        System.out.println("\n");

        System.out.println("19) Listando todos os livros...");
        try {
            livroService.listarLivros(livros);
        } catch (SemLivrosException e) {
            System.out.println('\n' + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("20) Faturando os pedidos 1 a 5, nesta ordem, para o mês de fevereiro de 2025...");
        System.out.println("\n");

        try{
            faturaService.faturarPedido(cliente_1, pedido1, dataEmissao_fevereiro28);
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido2, dataEmissao_fevereiro28);
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido3, dataEmissao_fevereiro28);
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido4, dataEmissao_fevereiro28);
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        try{
            faturaService.faturarPedido(cliente_1, pedido5, dataEmissao_fevereiro28);
        } catch(PedidoCanceladoException | PedidoIntegralmenteFaturadoException | EstoquesVaziosException e){
            System.out.println(e.getMessage());
        }

        System.out.println("21) Executando Relatório 1...");
        faturaService.executarRelatorio_1(faturaService.recuperarFaturas(), livro_1, 1, 2025);
        System.out.println("\n");

        System.out.println("22) Executando Relátorio 2...");
        faturaService.executarRelatorio_2(livros);
        System.out.println("\n");

        System.out.println("23) Executando Relatório 3...");
        faturaService.executarRelatorio_3(faturaService.recuperarFaturas(), livros, 2, 2025);

        System.out.println('\n' + "========================================================");
        System.out.println('\n' + "Teste Finalizado!");
        System.out.println('\n' + "========================================================\n");

    }
}

package com.caio.service;

import com.caio.dao.ItemDePedidoDAO;
import com.caio.exception.EntidadeNaoEncontradaException;
import com.caio.model.ItemDePedido;
import com.caio.util.FabricaDeDaos;

import java.util.List;

public class ItemDePedidoService {
    private final ItemDePedidoDAO itemDePedidoDAO = FabricaDeDaos.getDAO(ItemDePedidoDAO.class);

    public ItemDePedido incluir(ItemDePedido itemDePedido) { return itemDePedidoDAO.incluir(itemDePedido); }

    public ItemDePedido recuperarItemDePedidoPorId(int id){
        ItemDePedido itemDePedido = itemDePedidoDAO.recuperarPorId(id);
        if (itemDePedido == null)
            throw new EntidadeNaoEncontradaException(" \n ItemDePedido não encontrado!");
        return itemDePedido;
    }

    public ItemDePedido remover(int id) {
        ItemDePedido itemDePedido = recuperarItemDePedidoPorId(id);
        if (itemDePedido == null) {
            throw new EntidadeNaoEncontradaException("ItemDePedido inexistente.");
        }
        itemDePedidoDAO.remover(itemDePedido.getId());
        return itemDePedido;
    }

    public List<ItemDePedido> recuperarItemDePedidos(){
        return itemDePedidoDAO.recuperarTodos();
    }



}

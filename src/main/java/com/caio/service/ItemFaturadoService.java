package com.caio.service;

import com.caio.dao.ItemFaturadoDAO;
import com.caio.exception.EntidadeNaoEncontradaException;
import com.caio.model.ItemFaturado;
import com.caio.util.FabricaDeDaos;

import java.util.List;

public class ItemFaturadoService {
    private final ItemFaturadoDAO itemFaturadoDAO = FabricaDeDaos.getDAO(ItemFaturadoDAO.class);

    public ItemFaturado incluir(ItemFaturado itemFaturado){
        return itemFaturadoDAO.incluir(itemFaturado);
    }

    public ItemFaturado recuperarItemFaturadoPorId(int id){
        ItemFaturado itemFaturado = itemFaturadoDAO.recuperarPorId(id);
        if (itemFaturado == null)
            throw new EntidadeNaoEncontradaException(" \n ItemFaturado inexistente!");
        return itemFaturado;
    }

    public ItemFaturado remover(int id) {
        ItemFaturado itemFaturado = recuperarItemFaturadoPorId(id);
        if (itemFaturado == null) {
            throw new EntidadeNaoEncontradaException("ItemFaturado inexistente.");
        }
        itemFaturadoDAO.remover(itemFaturado.getId());
        return itemFaturado;
    }

    public List<ItemFaturado> recuperarItemFaturados(){
        return itemFaturadoDAO.recuperarTodos();
    }

}

package com.caio.exception;

public class QtdPedidaMaiorDoQueOEstoque extends RuntimeException {
    public QtdPedidaMaiorDoQueOEstoque(String message) {
        super(message);
    }
}

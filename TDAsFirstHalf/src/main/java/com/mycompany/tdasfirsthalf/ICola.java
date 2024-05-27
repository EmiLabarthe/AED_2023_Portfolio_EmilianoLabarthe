package com.mycompany.tdasfirsthalf;

public interface ICola<T> {
    /*
        – Anula
        – Frente
        – PoneEnCola(unElemento)
        – QuitaDeCola
        – Vacía
    */
    public void anular();
    public INodo<T> getFrente();
    public boolean poneEnCola(INodo<T> unElemento);
    public INodo<T> quitaDeCola();
    public boolean esVacia();
}
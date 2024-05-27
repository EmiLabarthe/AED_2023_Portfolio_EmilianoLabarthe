package com.mycompany.ut6_pd2;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author equipo 1
 */
public class Hash implements IHash {

    private int[] table;
    int size;

    public Hash(int capacidad) {
      this.table = new int[capacidad];
      this.size=capacidad;
    }
    
    public int getSize(){
        return size;
    }

    @Override
    public int buscar(int unaClave) {
        int comparaciones = 0;
        int hashedKey = funcionHashing(unaClave);
        while (table[hashedKey] != 0) {
            comparaciones++;
            if (comparaciones < this.size) {
                if (unaClave == table[hashedKey]) {
                    return comparaciones;
                }
                if (hashedKey == this.size) {
                    hashedKey = 0;
                }
            }else{
                return -comparaciones;
            }
        }
        return -comparaciones;
    }

    @Override
    public int insertar(int unaClave) {
        int comparaciones = 1;
        int hashedKey = funcionHashing(unaClave);
        if (table[hashedKey] == 0) {
            table[hashedKey]=unaClave;
            return comparaciones;
        }
        while (table[hashedKey] != 0 && comparaciones < this.size) {
            comparaciones++;
            if (comparaciones <= this.size) {
                hashedKey++;
                if (hashedKey == this.size) {
                    hashedKey = 0;
                }
            } else {
                return -1;
            }
        }
        table[hashedKey]=unaClave;
        return comparaciones;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % this.size;
    }

}
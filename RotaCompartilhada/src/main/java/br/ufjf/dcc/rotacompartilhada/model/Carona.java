/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 55329
 */
public class Carona {
    
    private Motorista motorista;
    private Passageiro passageiro;
    private Endereco origem;
    private Endereco destino;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private int duracaoHoras;
    
    public Carona(Passageiro passageiro,Motorista motorista,  Endereco origem, Endereco destino, LocalDateTime dataHoraInicio, int duracaoHoras){
        
        this.passageiro = passageiro;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraInicio.plusHours(duracaoHoras);
        
    }
    
    public boolean conflitaCom(LocalDateTime inicioOutra, LocalDateTime fimOutra){
        return this.dataHoraInicio.isBefore(fimOutra) && this.dataHoraFim.isAfter(inicioOutra);
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public void setOrigem(Endereco origem) {
        this.origem = origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }
    
    
}
    

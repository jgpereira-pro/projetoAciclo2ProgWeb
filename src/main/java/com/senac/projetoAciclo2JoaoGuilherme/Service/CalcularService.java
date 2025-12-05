package com.senac.projetoAciclo2JoaoGuilherme.Service;

import com.senac.projetoAciclo2JoaoGuilherme.dto.LadoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcularService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "provac2JoaoGuilherme")
    public Double calcularArea(LadoDTO ladoDTO) {

        // 1. Executa o cálculo
        Double area = ladoDTO.getLado() * ladoDTO.getLado();

        System.out.println("Recebido lado: " + ladoDTO.getLado());
        System.out.println("Área calculada: " + area);

        // 2. O retorno envia automaticamente a resposta para quem chamou
        return area;
    }
}
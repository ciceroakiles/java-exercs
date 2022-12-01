# Exercício 2 (13/08)

Fazer uma aplicação Java que liste os processos ativos e permita ao usuário entrar com o nome ou o PID do processo e o mate. A aplicação deverá funcionar minimamente em Windows e Linux.

O projeto precisa ter uma classe chamada KillController.java no package controller e uma classe Main.java no package view.

A classe KillController.java deve ter 4 métodos.

1) O primeiro, chamado os, que identifica e retorna o nome do sistema operacional (fazê-lo privado).

2) O segundo, chamado listaProcessos, que verifica o SO e, de acordo com este, seleciona o comando para listar os processos ativos. O método deve receber todas as linhas de saída do processo de listagem e exibi-las no console.

3) O terceiro, chamado mataPid, que recebe um PID como parâmetro de entrada, verifica o SO e, de acordo com este, seleciona o comando para matar o processo e o finaliza.

4) O quarto, chamado mataNome, que recebe um nome de processo como parâmetro de entrada, verifica o SO e, de acordo com este, seleciona o comando para matar o processo e o finaliza.

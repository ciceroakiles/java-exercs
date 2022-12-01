# javathreads-banking

Simular em Java a seguinte situação.

Um banco deve controlar saques e depósitos. O sistema pode permitir um saque e um depósito simultâneos, mas nunca 2 saques ou 2 depósitos simultâneos. Para calcular a transação (saque ou depósito), o método deve receber o código da conta, o saldo da conta e o valor a ser transacionado. Deve-se montar um sistema que deve considerar que 20 transações simultâneas serão enviadas ao mesmo (essas transações podem ser de qualquer natureza) e este deve tratar todas as transações de acordo com as regras acima.

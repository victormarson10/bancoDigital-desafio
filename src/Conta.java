
public abstract class Conta implements IConta{
	
	private static int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void sacar (double valor) {
		if(saldo > 0 && (saldo - valor) >= 0) {
			this.saldo -= valor;
		}else {
			System.out.println("Saldo insuficiente para sacar!");
			System.out.println("O saldo é : " + saldo + " e o valor a sacar é: " + valor);
		}
		
		
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(saldo > 0 && (saldo - valor) >= 0) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("Saldo insuficiente para transferir!");
			System.out.println("O saldo é : " + saldo + " e o valor a transferir é: " + valor);
		}
		
		
	}

	
	
}

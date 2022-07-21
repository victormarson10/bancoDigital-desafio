
public class Main {

	public static void main(String[] args) {
		Cliente usuario = new Cliente();
		usuario.setNome("Usuario");
		
		Conta cc = new ContaCorrente(usuario);
		cc.depositar(100);
		//cc.sacar(50);
		Conta poupanca = new ContaPoupanca(usuario);
		cc.transferir(51, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}

package engtelecom.std.projetoAutomocao.exceptions;

public class CenarioNaoEncontradoException extends RuntimeException {
  public CenarioNaoEncontradoException(String nome) {
    super("Não foi possível encontrar o ambiente com o nome: " + nome);
  }
}


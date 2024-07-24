package engtelecom.std.projetoAutomocao.exceptions;

public class AmbienteNaoEncontradoException extends RuntimeException {
  public AmbienteNaoEncontradoException(long id) {
    super("Não foi possível encontrar o ambiente com o id: " + id);
  }
}

package engtelecom.std.projetoAutomocao.exceptions;

public class DispositivoNaoEncontradoException extends RuntimeException {
  public DispositivoNaoEncontradoException(long id) {
    super("Não foi possível encontrar o dispositivo com o id: " + id);
  }
}

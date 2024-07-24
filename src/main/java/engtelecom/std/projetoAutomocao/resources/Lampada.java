package engtelecom.std.projetoAutomocao.resources;

public class Lampada extends Dispositivos {
  private int intensidade=3;
  private boolean ligado = false;
  private String cor = "branco";

  public Lampada() {
  }

  public Lampada(int id, String nome) {
    super(id, nome);
  }

  public void setLigado(boolean ligado) {
    this.ligado = ligado;
  }

  public boolean isLigar() {
    return ligado;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public long getId() {
    return super.getId();
  }

  @Override
  public void setNome(String nome) {
    super.setNome(nome);
  }

  @Override
  public void setId(long id) {
    super.setId(id);
  }

  public int getIntensidade() {
    return intensidade;
  }

  public void setIntensidade(int intensidade) {
    this.intensidade = intensidade;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor){
    this.cor = cor;
  }
}

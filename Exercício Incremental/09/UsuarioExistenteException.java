public class UsuarioExistenteException extends Exception
{
  public UsuarioExistenteException()
  {
    super("Já existe usuário com mesmo CPF ou RG no sistema.");
  }
  
  public UsuarioExistenteException(String mensagem)
  {
    super(mensagem);
  }
}

package projecto;
import Model.DAO.DAO_Anuncio;
import Model.VO.Anuncios;
import View.PreAnuncio_View;
import View.*;
import java.util.List;
import java.util.Vector;

public class Projecto {

    public static void main(String[] args) throws Exception {
        Vector v =new Vector();
        DAO_Anuncio dauA = new DAO_Anuncio();
        List<Anuncios> lista = dauA.listarTodos();
        for(int i = 0; i < lista.size(); i++) {
            Anuncios aux = lista.get(i);
            PreAnuncio_View preAd = new PreAnuncio_View();
            preAd.setId(aux.getId()+"");
            preAd.setpreco(aux.getPreco()+"");
            preAd.settipo(aux.getTipo());
            preAd.settitulo(aux.getTipoAnuncio());
            preAd.setUrl("storage\\venda-foco.png");
            preAd.criar();
            v.add(preAd);
        }    
        Login_View2 a = new Login_View2();
    }
    
}

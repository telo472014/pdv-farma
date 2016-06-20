import br.edu.ifsp.controller.Controller;
import br.edu.ifsp.controller.MedicamentoController;
import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.IModel;
import br.edu.ifsp.model.Medicamento;
import br.edu.ifsp.model.Pessoa;

public class Main {
    public static void main(String[] args){
        Medicamento medicamento = new Medicamento();
        medicamento.setNome("Texter");
        medicamento.setTarja("Sem");
        medicamento.setValor(8.2f);
        medicamento.setQuantidadeMin(50);
        medicamento.setRetemReceita(false);
        medicamento.setIdFabricante(2);
        Controller controller = new MedicamentoController(medicamento);
        controller.insert(medicamento);
        System.out.println(medicamento.getIdMedicamento());
    }
}

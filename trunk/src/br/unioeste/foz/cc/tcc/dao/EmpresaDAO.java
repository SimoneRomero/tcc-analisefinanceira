package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.empresa.CategoriaRegCVM;
import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.empresa.Pais;
import br.unioeste.foz.cc.tcc.empresa.Registro;
import br.unioeste.foz.cc.tcc.empresa.Setor;
import br.unioeste.foz.cc.tcc.empresa.SituacaoEmissor;
import br.unioeste.foz.cc.tcc.empresa.SituacaoRegCVM;
import br.unioeste.foz.cc.tcc.empresa.TipoParticipante;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class EmpresaDAO{

	private QueryMakerSingleton queryMaker;

	public EmpresaDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(Empresa empresa) throws SQLException {

		PaisDAO paisDAO = new PaisDAO();
		SituacaoRegCVMDAO situacaoRegCVMDAO = new SituacaoRegCVMDAO();
		TipoParticipanteDAO tipoDAO = new TipoParticipanteDAO();
		CategoriaRegCVMDAO categoriaDAO = new CategoriaRegCVMDAO();
		SituacaoEmissorDAO situacaoEmissorDAO = new SituacaoEmissorDAO();
		RelatorioAnualDAO relatorioAnualDAO = new RelatorioAnualDAO();

		String columns = "idempresa, codigoCVM, nome , cnpj, site, nomeAnterior, "
				+ "dataAlteracaoNome, dataConstituicao, dataRegCVM, dataInicioCVM, dataRegCategoria, "
				+ "dataInicioSituacao, atividade, descricaoatividade, Pais_idPais, TipoParticipante_idTipoParticipante,"
				+ "SituacaoEmissor_idSituacaoEmissor, SituacaoRegCVM_idSituacaoRegCVM, CategoriaRegCVM_idCategoriaRegCVM";

		Object[] values = { getNextId(),
				empresa.getCodigoCVM(),
				empresa.getNome(), 
				empresa.getCnpj(), 
				empresa.getSite(),
				empresa.getNomeAnterior(), 
				empresa.getDataAlteracaoNome(),
				empresa.getDataConstituicao(),
				empresa.getRegistro().getDataRegCVM(),
				empresa.getDataInicioCVM(),
				empresa.getRegistro().getDataRegCategoria(),
				empresa.getRegistro().getDataInicioSituacao(),
				empresa.getSetor().getAtividade(),
				empresa.getSetor().getDescricao(),
				paisDAO.inserir(empresa.getPais()),
				tipoDAO.inserir(empresa.getRegistro().getTipo()),
				situacaoEmissorDAO.inserir(empresa.getRegistro().getSituacaoEmissor()),
				situacaoRegCVMDAO.inserir(empresa.getRegistro().getSituacaoRegCVM()),
				categoriaDAO.inserir(empresa.getRegistro().getCategoriaCVM()) };

		int idEmpresa = queryMaker.insert("empresa", columns, values);
		for(RelatorioAnual r : empresa.getRelatorios())
			relatorioAnualDAO.inserir(r, idEmpresa);

		return idEmpresa;
	}

	public void alterar(Empresa empresa) throws SQLException {

		String[] columns = { "codigoCVM", "nome", "cnpj", "site",
				"nomeAnterior", "dataAlteracaoNome", "dataConstituicao",
				"dataRegCVM", "dataInicioCVM", "dataRegCategoria",
				"dataInicioSituacao", "atividade", "descricaoatividade",
				"Pais_idPais", "TipoParticipante_idTipoParticipante",
				"SituacaoEmissor_idSituacaoEmissor",
				"SituacaoRegCVM_idSituacaoRegCVM",
				"CategoriaRegCVM_idCategoriaRegCVM" };

		Object[] values = { empresa.getCodigoCVM(), empresa.getNome(),
				empresa.getCnpj(), empresa.getSite(),
				empresa.getNomeAnterior(), empresa.getDataAlteracaoNome(),
				empresa.getDataConstituicao(),
				empresa.getRegistro().getDataRegCVM(),
				empresa.getDataInicioCVM(),
				empresa.getRegistro().getDataRegCategoria(),
				empresa.getRegistro().getDataInicioSituacao(),
				empresa.getSetor().getAtividade(),
				empresa.getSetor().getDescricao(), empresa.getPais().getId(),
				empresa.getRegistro().getTipo().getId(),
				empresa.getRegistro().getSituacaoEmissor().getId(),
				empresa.getRegistro().getSituacaoRegCVM().getId(),
				empresa.getRegistro().getCategoriaCVM().getId() };

		queryMaker.updateWhere("empresa", columns, "idempresa = ?", values,
				empresa.getId());
	}

	public void remover(Empresa empresa) throws SQLException {
		queryMaker.deleteWhere("empresa", "idempresa = ?",
				empresa.getId());
	}

	public Empresa obter(int id) throws SQLException {

		ResultSet result = queryMaker.selectAllWhere("empresa",
				"idempresa = ?", id);

		PaisDAO paisDAO = new PaisDAO();
		SituacaoRegCVMDAO situacaoRegCVMDAO = new SituacaoRegCVMDAO();
		TipoParticipanteDAO tipoDAO = new TipoParticipanteDAO();
		CategoriaRegCVMDAO categoriaDAO = new CategoriaRegCVMDAO();
		SituacaoEmissorDAO situacaoEmissorDAO = new SituacaoEmissorDAO();
		RelatorioAnualDAO relatorioAnualDAO = new RelatorioAnualDAO();

		Pais pais = (Pais) paisDAO.obter(result.getInt(15));
		Registro registro = new Registro(result.getDate(11),
				result.getDate(12), result.getDate(9),
				(TipoParticipante) tipoDAO.obter(result.getInt(16)),
				(CategoriaRegCVM) categoriaDAO.obter(result.getInt(19)),
				(SituacaoEmissor) situacaoEmissorDAO.obter(result.getInt(17)),
				(SituacaoRegCVM) situacaoRegCVMDAO.obter(result.getInt(18)));
		Setor setor = new Setor(result.getString(13), result.getString(14));

		Empresa empresa = new Empresa(result.getString(2), result.getString(3),
				result.getString(4), result.getInt(5), setor, registro,
				result.getString(6), result.getDate(7), result.getDate(8),
				result.getDate(10), pais);
		empresa.setId(result.getInt(1));

		empresa.setRelatorios(relatorioAnualDAO.obterRelatorios(empresa.getId()));

		return empresa;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idempresa");
	}

}

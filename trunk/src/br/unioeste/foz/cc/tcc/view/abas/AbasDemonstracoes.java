package br.unioeste.foz.cc.tcc.view.abas;

import java.awt.BorderLayout;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.JTableHeader;

import br.unioeste.foz.cc.tcc.controller.AbasDemonstracoesActionManager;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

@SuppressWarnings("serial")
public class AbasDemonstracoes extends JTabbedPane{

	private TabelaEmpresa tabelaEmpresa;
	private AbasDemonstracoesActionManager actionManager;
	private JPopupMenu popup;

	public AbasDemonstracoes() {
		super(JTabbedPane.TOP);
		actionManager = new AbasDemonstracoesActionManager(this);
		addMouseListener(actionManager);
		
		popup = new JPopupMenu();
		popup.setOpaque(true);
		popup.setLightWeightPopupEnabled(true);

		JMenuItem mf;
		mf = new JMenuItem("Fechar");
		mf.addActionListener(actionManager);
		mf.setActionCommand("fechar");


		JMenuItem mft;
		mft = new JMenuItem("Fechar Todos");
		mft.addActionListener(actionManager);
		mft.setActionCommand("fechar todos");		
		
		popup.add(mf);
		popup.add(mft);
	}

	public void addAba(String atributos, int ano, Empresa empresa) {
		addTab(empresa.getNome() + " - " + ano + " - " + atributos, null,
				createTable(empresa, ano, atributos), null);
		setTabComponentAt(getTabCount() - 1, new BotaoComponente(this));
	}

	private JPanel createTable(Empresa empresa, int ano, String atributos) {

		tabelaEmpresa = new TabelaEmpresa();

		tabelaEmpresa.setEmpresa(empresa, ano, atributos);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JTableHeader jth = tabelaEmpresa.getTableHeader();

		JScrollPane j2 = new JScrollPane();
		j2.setViewportView(tabelaEmpresa);

		jp.add(jth, BorderLayout.PAGE_START);
		jp.add(j2, BorderLayout.CENTER);

		return jp;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public void setPopup(JPopupMenu popup) {
		this.popup = popup;
	}
}

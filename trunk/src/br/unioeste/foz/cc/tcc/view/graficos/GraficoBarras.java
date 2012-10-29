package br.unioeste.foz.cc.tcc.view.graficos;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCAnalisarDemonstrativos;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

/**
 * A simple demonstration application showing how to create a dual axis chart
 * based on data from two {@link CategoryDataset} instances.
 * 
 */
@SuppressWarnings("serial")
public class GraficoBarras extends JFrame {

	private JFreeChart chart;

	/**
	 * Creates a new demo instance.
	 * 
	 * @param title
	 *            the frame title.
	 */
	public GraficoBarras(final String tituloFrame, String tituloGrafico,
			String eixoX, String eixoY) {

		super(tituloFrame);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// create the chart...
		chart = ChartFactory.createBarChart(tituloGrafico, // chart title
				eixoX, // domain axis label
				eixoY, // range axis label
				new DefaultCategoryDataset(), // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips?
				false // URL generator? Not required...
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.white);
		// chart.getLegend().setAnchor(Legend.SOUTH);

		// get a reference to the plot for further customisation...
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
		plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

		// final CategoryDataset dataset2 = createDataset2();
		// plot.setDataset(1, dataset2);
		// plot.mapDatasetToRangeAxis(1, 1);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

		// LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
		// renderer2.setToolTipGenerator(new
		// StandardCategoryToolTipGenerator());
		// plot.setRenderer(0, renderer2);
		// plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
		// OPTIONAL CUSTOMISATION COMPLETED.

		// add the chart to a panel...
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}

	public void addEmpresa(Empresa e, HashBackMap<Date, Double> indicadores) {
		CategoryPlot plot = chart.getCategoryPlot();
		DefaultCategoryDataset dataset = (DefaultCategoryDataset) plot
				.getDataset(0);

		Calendar calendar = Calendar.getInstance();

		List<Date> datas = new ArrayList<Date>(indicadores.keySet());
		Collections.sort(datas);

		for (Date data : datas) {
			calendar.setTime(data);
			dataset.addValue(
					indicadores.get(data),
					e.getNome(),
					String.valueOf(calendar.get(Calendar.DAY_OF_MONTH) + "/"
							+ (calendar.get(Calendar.MONTH) + 1) + "/"
							+ calendar.get(Calendar.YEAR)));
		}

		plot.setDataset(0, dataset);
		// plot.mapDatasetToRangeAxis(1, 1);
	}

	public static void main(String[] args) throws FileNotFoundException,
			ClassNotFoundException, SQLException, IOException {
		UCManterEmpresa m = new UCManterEmpresa();
		UCAnalisarDemonstrativos a = new UCAnalisarDemonstrativos();

		// System.out.println(Double.valueOf("26.122.310".replace(".",
		// "").replace(",", ".")));

		GraficoBarras gb = new GraficoBarras("", "", "", "");

		gb.addEmpresa(m.obterEmpresa(9512, true),
				a.calcular("PMPC", m.obterEmpresa(9512, true)));
		gb.addEmpresa(m.obterEmpresa(14311, true),
				a.calcular("PMPC", m.obterEmpresa(14311, true)));
		gb.addEmpresa(m.obterEmpresa(15300, true),
				a.calcular("PMPC", m.obterEmpresa(15300, true)));
		gb.addEmpresa(m.obterEmpresa(4170, true),
				a.calcular("PMPC", m.obterEmpresa(4170, true)));

		// System.out.println(a.calcular("PMPC", m.obterEmpresa(4170, true)));
		// System.out.println(a.calcular("PMPC", m.obterEmpresa(15300, true)));
		// System.out.println(a.calcular("PMPC", m.obterEmpresa(2429, true)));
		// System.out.println(a.calcular("PMPC", m.obterEmpresa(9512, true)));
		// System.out.println(a.calcular("PMPC", m.obterEmpresa(14311, true)));
	}

}
package tn.esprit.auction.services.gestion.panel;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.auction.domain.Panel;

@Local
public interface PanelServicesLocal {
	Boolean addPanel(Panel panel );
	Boolean updatePanel(Panel panel);
	Boolean deletePanel(Panel panel);
	Panel findPanelById(Integer idPanel);
	List<Panel>findAllPanels();
	
}

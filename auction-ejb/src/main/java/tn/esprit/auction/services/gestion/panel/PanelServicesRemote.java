package tn.esprit.auction.services.gestion.panel;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Panel;

@Remote
public interface PanelServicesRemote {
	Boolean addPanel(Panel panel );
	Boolean updatePanel(Panel panel);
	Boolean deletePanel(Panel panel);
	Panel findPanelById(Integer idPanel);
	List<Panel>findAllPanels();
	
}

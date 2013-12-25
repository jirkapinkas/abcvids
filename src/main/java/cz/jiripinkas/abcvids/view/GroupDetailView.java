package cz.jiripinkas.abcvids.view;

import cz.jiripinkas.abcvids.mvp.MVPView;

public interface GroupDetailView extends MVPView {

	String getItemDescription();
	
	String getKeywords();
	
	String getName();
	
	String getSeoDescription();
}

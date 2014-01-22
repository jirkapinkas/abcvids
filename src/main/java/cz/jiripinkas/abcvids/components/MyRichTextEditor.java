package cz.jiripinkas.abcvids.components;

import org.vaadin.openesignforms.ckeditor.CKEditorConfig;
import org.vaadin.openesignforms.ckeditor.CKEditorTextField;

@SuppressWarnings("serial")
public class MyRichTextEditor extends CKEditorTextField {

	private static final CKEditorConfig config;

	static {
		config = new CKEditorConfig();
		config.useCompactTags();
		config.disableElementsPath();
		config.disableSpellChecker();
		config.disableResizeEditor();
		config.setToolbarCanCollapse(false);
		// see http://docs.cksource.com/CKEditor_3.x/Developers_Guide/Toolbar
		config.addCustomToolbarLine(" { name: 'styles', items : ['Source','Styles','Format','Font','FontSize','TextColor','BGColor','Maximize', 'ShowBlocks'] }");
	}

	public MyRichTextEditor(String caption) {
		super(config);
		setCaption(caption);
	}
}

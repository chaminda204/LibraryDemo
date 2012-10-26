Ext.require([ 'Ext.direct.*', 'Ext.data.*', 'Ext.grid.*' ]);

Ext.onReady(function() {

	Ext.application({
		name : 'My Library Suppliers',
		launch : function() {
		var containerPanel = Ext.create('Ext.panel.Panel',
			{
				renderTo : Ext.getBody(),
				width : 900,
				height : 800,
				title : 'Library Service',
				layout : 'column',
			});

	// Form panel 

			var allocationlForm = new Ext.form.FormPanel(
				{
					id : 'allocation_Form',
					labelWidth : 70,
					frame : true,
					bodyStyle : 'padding:5px 5px 0',
					height : 110,

					items : [ {
						xtype : 'textfield',
						name : 'title',
						width : '100%',
						fieldLabel : 'Book Title',
						id : "title",
						allowBlank : false
					}, {

						xtype : 'numberfield',
						hideTrigger : true,
						fieldLabel : 'Quantity',
						width : '100%',
						name : 'book_Qty',
						id : 'book_Qty',
						allowBlank : false
					} ],

					buttons : [
					   {
							text : 'Allocate',
							handler : function() {
								var title = Ext.getCmp("title").getValue();
								var qty = Ext.getCmp('book_Qty').getValue();
								Ext.Ajax.request({
									method : 'POST',
									url : 'library/service.ajax?command=allocateBooks',
									params : {book_title : title,
											  book_Qty : qty },
									success : function(response) {
										
										//Ext.Msg.alert('Status','Changes saved successfully.');
										handleSuccess(response);
										allocationlForm.getForm().reset();
										},
									failure : function(response) {
										//Ext.Msg.alert('Error while allocating books');
										}
									});
								}
					   	},
							{
					   		text : 'Clear Data',
							handler : function() {
								allocationlForm.getForm().reset();
								}
						 }]

					});

			containerPanel.add(allocationlForm);

				// Library Details Grid

			
			Ext.define('Library', {
			    extend: 'Ext.data.Model',
			    fields: [
			        {name: 'library', type: 'string'},
			        {name: 'weighting',  type: 'string'}
			    ],
			    sorters: [{
			         property: 'weighting',
			         direction: 'DESC'
			     }]
			});

			/*var library_Store = Ext.create('Ext.data.Store', {
			    model: 'Library',
			    proxy: {
			        type: 'ajax',
			        url : 'library/service.ajax?command=loadLibraries',
			        reader: {
			            type: 'json',
			            root: 'libraries'
			        }
			    },
			  //autoLoad: true
			});*/
			
            var library_Store =  Ext.create('Ext.data.Store', {
                model: 'Library',
                data : [
                    {library: 'Logan',    weighting: '10 %'},
                    {library: 'Gold Coast', weighting: '30 %'},
                    {library: 'Toowomba', weighting: '20 %'},
                    {library: 'Mt Gravett', weighting: '40 %'},
                    {library: 'Hellanswale', weighting: '0 %'}
                    
                ]
            });

			// Read JSON data and adding to Summary
			function handleSuccess(response) {

				var jsonData = Ext.JSON.decode(response.responseText);
					summary_Store.loadData(jsonData);
					summary_Store.sync();

					}

				var grid = Ext.create('Ext.grid.Panel', {
				store : library_Store,
				columns : [ {
					dataIndex : 'library',
					width : 500,
					text : 'Library'
				  }, {
					dataIndex : 'weighting',
					width : 397,
					text : 'Weighting'
				} ],
					height : 300,
					width : 900,
					title : 'Registered Libraries',
					renderTo : Ext.getBody()
				});

		containerPanel.add(grid);

		// Summary Grid
		Ext.define('Summary', {extend : 'Ext.data.Model',
			fields : [ {name : 'library',
						type : 'string'
					} ]
				});

		var summary_Store = Ext.create('Ext.data.Store',
			{
			 	model : 'Summary',
				proxy : {type : 'ajax',
				url : '',
				reader : {
					type : 'json'
						}
					}
				});

		var summary_Grid = Ext.create('Ext.grid.Panel', {
			store : summary_Store,
			columns : [ {
				dataIndex : 'library',
				width : 890,
				text : 'Allocated Library'
				} ],
				height : 200,
				width : 900,
				title : 'Allocation Summary',
				renderTo : Ext.getBody()
			});

		containerPanel.add(summary_Grid);
		//library_Store.load();
		}
	});
});
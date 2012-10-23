Ext.require([ 'Ext.direct.*', 'Ext.data.*', 'Ext.grid.*' ]);

Ext.onReady(function() {

    Ext.application({
        name : 'Peter Pal Library Suppliers',
        launch : function() {
            var containerPanel = Ext.create('Ext.panel.Panel', {
                renderTo : Ext.getBody(),
                width : 900,
                height : 800,
                title : 'Library Service',
                layout : 'column',
            });

            // Form panel - Used In EXT js 3

            var allocationlForm = new Ext.form.FormPanel({
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
                    id : "title" ,
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

                buttons : [ {
                    text : 'Allocate',

                    handler : function() {
                        var title = Ext.getCmp("title").getValue()
                        var qty = Ext.getCmp('book_Qty').getValue();

                        Ext.Ajax.request({
                            method : 'POST',
                            url : 'library/service.ajax?command=allocateBooks',
                            params:{book_title : title,
                                   book_Qty : qty},
                            success : function(response) {
                               // alert('Success ' + response.responseText)
                                //Ext.Msg.alert('Status', 'Changes saved successfully.');
                            	//addRecordToSummaryGrid(response);
                            	allocationlForm.getForm().reset();
                            },
                            failure : function(response) {
                                //alert('Error' +response)
                                //Ext.Msg.alert('Error while allocating books');
                            }
                        });
                    }

                }, {
                    text : 'Clear Data',
                    handler : function() {
                        allocationlForm.getForm().reset();
                    }
                } ]

            });

            containerPanel.add(allocationlForm);

            /*
             * Ext.regModel('User', { fields: ['id', 'name'], proxy: { type:
             * 'ajax', url : '/library.ajax', reader: { type: 'json', root:
             * 'users' } } });
             *
             * var library_Store = new Ext.data.Store({ model: 'User', proxy: {
             * type: 'ajax', url : 'users.json', reader: 'json' }, autoLoad:
             * true });
             */

            // Set up a model to use in our Store
            Ext.define('Library', {
                extend : 'Ext.data.Model',
                fields : [ {
                    name : 'library',
                    type : 'string'
                }, {
                    name : 'weighting',
                    type : 'string'
                } ]
            });

            var library_Store = Ext.create('Ext.data.Store', {
                model : 'Library',
                proxy : {
                    type : 'ajax',
                    url : 'Library/getAllLibraries.ajax?command=loadLibraries',
                    reader : {
                        type : 'json'
                        //root : 'libraries'
                    }
                },
                //autoLoad : true
                
            });
            

            /*  var recordLibrary = Ext.data.Record.create([{name: 'library'}]);

            function addRecordToSummaryGrid(scem) {
                if(scem != null && scem.length > 0) {
                    for (var i = 0; i < scem.length; i++) {
                        // record array
                        var recordArray = scem[i];
                        var nameValue = recordArray[1]; //only we need to show name
                        //summary_Store.add(new recordLibrary({library: nameValue}));
                        summary_Store.add(new summary_Store.recordType({library: nameValue}));
                    }
                }
            }
            */
            
            
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
            


            
            Ext.define('Summary', {
                extend : 'Ext.data.Model',
                fields : [ {
                    name : 'library',
                    type : 'string'
                } ]
            });

            var summary_Store = Ext.create('Ext.data.Store', {
                model : 'Summary',
                proxy : {
                    type : 'ajax',
                    url : 'Library/getAllLibraries.ajax?command=loadLibraries',
                    reader : {
                        type : 'json'
                        //root : 'libraries'
                    }
                },
                //autoLoad : true
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
            
            
            
            var resultForm = Ext.create('Ext.form.Panel', {
                title : 'Books Allocated To',
                bodyPadding : 5,
                width : 900,
                frame : true,
                bodyStyle : 'padding:5px 5px 0',

                layout : 'column',
                defaults : {
                    anchor : '100%'
                },

                items : [ summary_Grid ]

            });

            containerPanel.add(resultForm);

        }
    
    });
});
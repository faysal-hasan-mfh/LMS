package MainPack;

import DatabasePack.*;

import DatabasePack.ExistPack.*;
import DatabasePack.GetPack.*;
import InsertDBPack.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faysal
 */
public class Main extends javax.swing.JFrame {

    
    CreateFolderPath cfp=new CreateFolderPath();
    //ServiceDB
    
    ServiceDBExistance sdbeobj= new ServiceDBExistance();
    //PersonDB
    
    PersonDBExistance pdbeobj= new PersonDBExistance();
    //FineDB
    FineDBExistance fdbeobj = new FineDBExistance();
    
    
    //BooksDB
    BooksDBExistance bdbeobj = new BooksDBExistance();
    
    
    //LibrarianDB
    GetDataFromLibrarianDB gdfldbobj=new GetDataFromLibrarianDB();
    InsertLibrarianDB ildbobj= new InsertLibrarianDB();
    LibDBExistance ldbeobj= new LibDBExistance();
    
    
    
    
    //ServiceForm Main
    
    
    ServiceFormMain serviceObj=new ServiceFormMain();
    
    
    
    String randomString;
    
    
    
    
    
  
    
    
    
    /**
     * Creates new form Main
     */
    public Main() {
        
        CreateBooksDatabase cbdobj=new CreateBooksDatabase();
        CreateFineDatabase cfdobj=new CreateFineDatabase();
        CreateLibrarianDB cldobj=new CreateLibrarianDB();
        CreatePersonDatabase cpdobj=new CreatePersonDatabase();
        CreateServiceDatabase csdobj=new CreateServiceDatabase();
        
        //library ..
        if(!ldbeobj.LibDBExist())
        {
        cldobj.createDatabaseMethod();
        }
        
        // books.....
         if(!bdbeobj.BooksDBExist())
        {
        cbdobj.createDatabaseMethod();
        }
        
         // fine......
         if(!fdbeobj.FineDBExist()) {
            cfdobj.createDatabaseMethod();
        }
        
        //person.......
         if(!pdbeobj.PersonDBExist()) {
            cpdobj.createDatabaseMethod();
        }
        
        //service..........
         if(!sdbeobj.ServiceDBExist()) {
            csdobj.createDatabaseMethod();
        }
        
        
        
        
        
        initComponents();
        setAdminFrontList();
        
        
        
        random();
    }
    public void random()
    {
    java.util.Random rn=new java.util.Random();
		
		double val;
		int number[]=new int[4];
		
		for(int i=0;i<4;i++)
		{
			val=rn.nextGaussian();
		
			if(val<0)
			{
				val*=-1;
				val=10*val;
				if(val>10){
					val=val/10;
				System.out.print(""+(int)val);
				number[i]=(int) val;
				}
				else
				{
					System.out.print(""+(int)val);
					number[i]=(int) val;
				}
			}
			else{
				val=10*val;
				if(val>10){
					val=val/10;
			System.out.print(""+(int)val);
			number[i]=(int) val;
				}
				else
				{
					System.out.print(""+(int)val);
					number[i]=(int) val;
				}
			}
		}
		
		System.out.println();
		
		for(int j=0;j<number.length;++j)
		{
			System.out.print(number[j]);
			
		}
		
	//	int[] arr = new int[] { 1, 0, 1, 0 };
		StringBuilder sb = new StringBuilder(number.length);
		for (int i : number) {
		  sb.append(i);
		}
		 randomString = sb.toString(); 
		System.out.println("\nS>"+randomString);
                randomLabel.setText(randomString);
                
		
	//	System.out.println("\nString >"+Arrays.toString(number));
	
    
    }

    public void setList()
    {
    
                String getLibrarianName[]= gdfldbobj.getWNFromDB();
                int lengthofid=gdfldbobj.LastID();
                
              //  System.out.println(">>"+lengthofid);
                if(lengthofid!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getLibrarianName)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                  //  System.out.println(">>>>"+dlm.toString());
                                }
                        }
                
                    
                     
                         adminList.setModel(dlm);
                         //System.out.println(">>>>>>"+jList1);
                }
                else
                {
                //JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No AdMin");
                adminList.setModel(dlm);
                }
    
    }
    public void setAdminFrontList()
    {
    
                String getLibrarianName[]= gdfldbobj.getWNFromDB();
                int lengthofid=gdfldbobj.LastID();
                
              //  System.out.println(">>"+lengthofid);
                if(lengthofid!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getLibrarianName)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                  //  System.out.println(">>>>"+dlm.toString());
                                }
                        }
                
                    
                     
                         adminFrontList.setModel(dlm);
                         //System.out.println(">>>>>>"+jList1);
                }
                else
                {
            //    JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No AdMin");
                adminFrontList.setModel(dlm);
                }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logNametf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        logPftf = new javax.swing.JPasswordField();
        logNameOkbutton = new javax.swing.JButton();
        logNameCancelButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminFrontList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        adminInfoFrontList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        randomLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        getRandomTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        loggerLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        caNametf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        caPwtf = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        caEmltf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        caAddtf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cac1tf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cac2tf = new javax.swing.JTextField();
        createAccountOkButton = new javax.swing.JButton();
        caCancelButt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        caOidtf = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        adminInformationList = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon1.jpg")).getImage());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name :>");

        logNametf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password :>");

        logPftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        logNameOkbutton.setText("OK");
        logNameOkbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logNameOkbuttonActionPerformed(evt);
            }
        });

        logNameCancelButton.setText("CANCEL");
        logNameCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logNameCancelButtonActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Admin List :>");

        adminFrontList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        adminFrontList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                adminFrontListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(adminFrontList);

        adminInfoFrontList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        adminInfoFrontList.setToolTipText("");
        jScrollPane4.setViewportView(adminInfoFrontList);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
        );

        jLabel4.setText("Enter the following text :>");

        randomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setText("Reload");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        getRandomTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getRandomTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRandomTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getRandomTF, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(randomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jButton3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(randomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getRandomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Log in as :>");

        loggerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loggerLabel.setText("NO ONE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logNametf)
                            .addComponent(logPftf)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(logNameOkbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logNameCancelButton))
                            .addComponent(loggerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(logNametf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(logPftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(loggerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logNameCancelButton)
                            .addComponent(logNameOkbutton)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Log In :", jPanel2);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Name :>");

        caNametf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        caNametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caNametfActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Password :>");

        caPwtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("E-mail :>");

        caEmltf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Address :>");

        caAddtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Contact No :> .1");

        cac1tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Contact No :> .2");

        cac2tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        createAccountOkButton.setText("OK");
        createAccountOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountOkButtonActionPerformed(evt);
            }
        });

        caCancelButt.setText("CANCEL");
        caCancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caCancelButtActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Official_id :>");

        caOidtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(createAccountOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                        .addComponent(caCancelButt))
                    .addComponent(caNametf)
                    .addComponent(caPwtf)
                    .addComponent(caEmltf)
                    .addComponent(caAddtf)
                    .addComponent(cac1tf)
                    .addComponent(cac2tf)
                    .addComponent(caOidtf))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caNametf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caPwtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caEmltf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caAddtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cac1tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cac2tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caOidtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccountOkButton)
                    .addComponent(caCancelButt))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Create Account :", jPanel6);

        adminList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        adminList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                adminListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(adminList);

        adminInformationList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(adminInformationList);

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Admin List :", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountOkButtonActionPerformed
        String caName, caPw, caeMl, caadd,cac1,cac2,caoid;
        String superPassword = JOptionPane.showInputDialog(this, "To Create Account Please Enter Super Password .");
        
        if(superPassword!=null)
        {
            
        
        if(superPassword.equals("nstu")){
         //   JOptionPane.showMessageDialog(this, "You Can Create Account..", "PerMission Granted", JOptionPane.INFORMATION_MESSAGE);
        
            
            caName= caNametf.getText().toString().trim();
        caPw= caPwtf.getText().toString();
        caeMl= caEmltf.getText().toString().trim();
        caadd= caAddtf.getText().toString().trim();
        cac1= cac1tf.getText().toString().trim();
        cac2= cac2tf.getText().toString().trim();
        caoid= caOidtf.getText().toString().trim();
        
        if(gdfldbobj.getOfficerExistFromDB(caoid))
        {
        
            JOptionPane.showMessageDialog(this, "Sorry This OfficialID Is Already Existed..!", "Already Exists", JOptionPane.ERROR_MESSAGE);
       
            
            
            caOidtf.setText("");
            /*
            caNametf.setText("");
            caPwtf.setText("");
            caEmltf.setText("");
            caAddtf.setText("");
            cac1tf.setText("");
            cac2tf.setText("");
            caOidtf.setText("");
        
        */
            
            
        }
        
        else if(gdfldbobj.getAdNameExistFromDB(caName))
        {
         JOptionPane.showMessageDialog(this, "Sorry This Name Is Already Existed..!", "Already Exists", JOptionPane.ERROR_MESSAGE);
        caNametf.setText("");
        }
        
       else if(caNametf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your name..!");
        }
        else if(caPwtf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter password..!");
        }
        else if(caEmltf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your email..!");
        }
        else if(caAddtf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your address..!");
        }
        else if(cac1tf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your first contact..!");
        }
        else if(cac2tf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your second contact..!");
        }
        else if(caOidtf.getText().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter your Official Id..!");
        }
        else
        {
        System.out.println("problem");
           // 
            
             caNametf.setText("");
            caPwtf.setText("");
            caEmltf.setText("");
            caAddtf.setText("");
            cac1tf.setText("");
            cac2tf.setText("");
            caOidtf.setText("");
            
             setList();
        }
        boolean isNumber=false;
        if(caName.startsWith("0")||caName.startsWith("1")||caName.startsWith("2")||caName.startsWith("3")||caName.startsWith("4")||caName.startsWith("5")||caName.startsWith("6")||caName.startsWith("7")||caName.startsWith("7")||caName.startsWith("8")||caName.startsWith("9")||caName.startsWith(" "))
        {
        JOptionPane.showMessageDialog(this, "Sorry.. Name cannot be start with numbers or space","No PerMission", JOptionPane.ERROR_MESSAGE);
        isNumber=true;
        }
        
        
        //.......email.checking.............
			char check1= '@';
			char check2= '.';
			int checkCount=0;
			boolean specch=false;
			boolean isspace=false;
			boolean illCH=false;
			boolean inValid=false;
			char illegalCh[]=new char [] {'~','`','!','#','$','%','^','&','*','(',')','-','+','=','|','/'};
			String email=caeMl;
			
			for(int i=0;i<email.length();++i)
			{
				if((email.charAt(i))==check1||(email.charAt(i))==check2)
				{
					
					System.out.println("HERE");
					specch=true;
					checkCount++;
				}
				if(email.charAt(i)==' ')
				{
					isspace=true;
				}
				
			for(int j=0;j<illegalCh.length;++j)
				{
					if(email.charAt(i)==illegalCh[j])
					{
						
						illCH=true;
					}
				}
				
			}
                        
                        if(specch==true && checkCount==2 && !(email.startsWith(" "))&& !isspace && !illCH)
			{
				System.out.println("E-mail: >"+email+"<");
				
			}
			else
			{
				if(specch==false)
				{
					System.out.println("CH>"+specch);
                                        JOptionPane.showMessageDialog(this, "Sorry.. invalid email","No PerMission", JOptionPane.ERROR_MESSAGE);
                                        inValid=true;
				}
				else if(checkCount>2)
				{
					System.out.println("checkcount>"+checkCount);
                                        JOptionPane.showMessageDialog(this, "Sorry.. invalid email","No PerMission", JOptionPane.ERROR_MESSAGE);
                                        inValid=true;
                                }
				else if(isspace)
				{
					System.out.println("contains blank inside");
                                        JOptionPane.showMessageDialog(this, "Sorry.. invalid email","No PerMission", JOptionPane.ERROR_MESSAGE);
				inValid=true;
                                }
				else if(illCH)
				{
					System.out.println("contains illegal character");
                                        JOptionPane.showMessageDialog(this, "Sorry.. invalid email","No PerMission", JOptionPane.ERROR_MESSAGE);
				inValid=true;
                                }
				else
				{
					System.out.println("SOMETHING>> OTHER>>.");
                                        JOptionPane.showMessageDialog(this, "Sorry.. invalid email","No PerMission", JOptionPane.ERROR_MESSAGE);
				inValid=true;
                                }
				
			}
        
                        if(isNumber)
                        {
                        System.out.println("False");
                        }
                    boolean contactP=false;    
                        if(!(cac1.startsWith("0")|| cac1.startsWith("1")||cac1.startsWith("2")||cac1.startsWith("3")||cac1.startsWith("4")||
                                cac1.startsWith("5")||cac1.startsWith("6")||cac1.startsWith("7")||cac1.startsWith("8")||cac1.startsWith("9")))
                        {
                            contactP=true;
                        JOptionPane.showMessageDialog(this, "contact must be start with number","Wrong insertion", JOptionPane.INFORMATION_MESSAGE); 
                        }
                        else if(!(cac2.startsWith("0")|| cac2.startsWith("1")||cac2.startsWith("2")||cac2.startsWith("3")||cac2.startsWith("4")||
                                cac2.startsWith("5")||cac2.startsWith("6")||cac2.startsWith("7")||cac2.startsWith("8")||cac2.startsWith("9")))
                        {
                            
                            contactP=true;
                        JOptionPane.showMessageDialog(this, "contact must be start with number","Wrong insertion", JOptionPane.INFORMATION_MESSAGE);
                        }
        if(!(gdfldbobj.getOfficerExistFromDB(caoid))&&!(gdfldbobj.getAdNameExistFromDB(caName))&&!(caName.equals(""))&&!(caPw.equals("")&&!(caeMl.equals(""))&&!(caadd.equals(""))&&!(cac1.equals(""))&&!(cac2.isEmpty())&&!(caoid.isEmpty())&&(specch==true && checkCount==2 && !(email.startsWith(" "))&& !isspace && !illCH)) &&!inValid && !contactP)
        {
           // System.out.println("IN"+inValid);
        ildbobj.InsertToDB(caoid, caName, caeMl, caadd, cac1, cac2, caPw);
   //     JOptionPane.showMessageDialog(this, "Inserted.......","DB ADD", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
         JOptionPane.showMessageDialog(this, "Sorry.. Problem Occured, Please Re-Type ","No PerMission", JOptionPane.ERROR_MESSAGE);
       
        System.out.println(isspace);
           //&&!(caEmltf.getText().equals(""))&&!(caAddtf.getText().equals(""))&&!(cac1tf.getText().equals(""))&&!(caOidtf.getText().equals(""))
           
           
          
           
        }
        
        
        //...........before...................
       
        }
         else
        {
        JOptionPane.showMessageDialog(this, "Sorry.. You Donot Have Any PerMission..To Create Account..!","No PerMission", JOptionPane.ERROR_MESSAGE);
        }
        
        }
         else
        {
        JOptionPane.showMessageDialog(this, "Sorry.. You Must Have To Enter Super keyword !","Wrong Way", JOptionPane.ERROR_MESSAGE);
        }
        
       
    }//GEN-LAST:event_createAccountOkButtonActionPerformed

    private void caNametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caNametfActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_caNametfActionPerformed

    private void caCancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caCancelButtActionPerformed
        
        
            caNametf.setText("");
            caPwtf.setText("");
            caEmltf.setText("");
            caAddtf.setText("");
            cac1tf.setText("");
            cac2tf.setText("");
            caOidtf.setText("");
    }//GEN-LAST:event_caCancelButtActionPerformed

    private void logNameOkbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logNameOkbuttonActionPerformed
        
        String LogInName= logNametf.getText().toString();
        String LogPW= logPftf.getText().toString();
        
        //..................................................................cap
        String getValue= getRandomTF.getText().toString();
        
        if(getValue!=null)
        {
        
            if(getValue.equals(randomLabel.getText()))
            {
          //  JOptionPane.showMessageDialog(rootPane,"correct number", "correct..", JOptionPane.INFORMATION_MESSAGE);
        
            }
            else if(getValue.equals(""))
            {
            JOptionPane.showMessageDialog(rootPane,"Please insert The Random number !", "Error !", JOptionPane.ERROR_MESSAGE);
            }
            else{
            
            JOptionPane.showMessageDialog(rootPane,"Sorry.. wrong number", "Error !", JOptionPane.ERROR_MESSAGE);
        
            }
        }
        else
        {
        JOptionPane.showMessageDialog(rootPane,"Sorry.. Null value not acceptable!", "Error !", JOptionPane.ERROR_MESSAGE);
        
        }
        
        //...................................................cap..............
        
        if(gdfldbobj.getAdNameExistFromDB(LogInName) && gdfldbobj.getPasswordFromDB(LogPW) && getValue.equals(randomLabel.getText()))
        {
         JOptionPane.showMessageDialog(this, "Welcome.. "+LogInName);
         
         loggerLabel.setText(logNametf.getText().toString());
         
        logNametf.setText("");
        logPftf.setText("");
        getRandomTF.setText("");
        
        setList();
        serviceObj.setVisible(true);
        serviceObj.setLocationRelativeTo(null);
       // serviceObj.setExtendedState(JFrame.MAXIMIZED_BOTH);
        serviceObj.setList();
        serviceObj.setPersonList();
       // this.dispose();
        random();
        
    //    Main.this.dispose();
        
        }
        else{
           if(!LogInName.isEmpty())
        JOptionPane.showMessageDialog(this, "Sorry.. "+LogInName+" is not valid.... OR WRONG number inserted..");
           else
           {
               LogInName="\"Unknown\"";
           JOptionPane.showMessageDialog(this, "Sorry.. "+LogInName+" is not valid.... OR WRONG number inserted..");
           }
        logNametf.setText("");
        logPftf.setText("");
        getRandomTF.setText("");
        random();
        }
        
        
    }//GEN-LAST:event_logNameOkbuttonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void adminListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_adminListValueChanged

        String getSelectedValue= (String) adminList.getSelectedValue();
        if(!evt.getValueIsAdjusting() && getSelectedValue!=null){
            String booksInfo[]= gdfldbobj.getAllInfoFromDB(getSelectedValue);
            int infoSize= gdfldbobj.LastID();
            if(infoSize!=0){
                DefaultListModel dlm=new DefaultListModel();

                for(String wan: booksInfo)
                {
                    if(wan!=null) {
                        dlm.addElement(wan);
                        //  System.out.println(">>>>"+dlm.toString());
                    }
                }

                adminInformationList.setModel(dlm);
                //System.out.println(">>>>>>"+jList1);
            }
            else
            {
                //  JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No Librarian Info In Database !");
                adminInformationList.setModel(dlm);
            }
        }
    }//GEN-LAST:event_adminListValueChanged

    private void logNameCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logNameCancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_logNameCancelButtonActionPerformed

    private void adminFrontListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_adminFrontListValueChanged
      
        String getSelectedValue= (String) adminFrontList.getSelectedValue();
        if(!evt.getValueIsAdjusting() && getSelectedValue!=null){
            String booksInfo[]= gdfldbobj.getAllInfoFromDB(getSelectedValue);
            int infoSize= gdfldbobj.LastID();
            if(infoSize!=0){
                DefaultListModel dlm=new DefaultListModel();

                for(String wan: booksInfo)
                {
                    if(wan!=null) {
                        dlm.addElement(wan);
                        //  System.out.println(">>>>"+dlm.toString());
                    }
                }

                adminInfoFrontList.setModel(dlm);
                //System.out.println(">>>>>>"+jList1);
            }
            else
            {
                //  JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No Librarian Info In Database !");
                adminInfoFrontList.setModel(dlm);
            }
        }
    }//GEN-LAST:event_adminFrontListValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
                String getLibrarianName[]= gdfldbobj.getWNFromDB();
                int lengthofid=gdfldbobj.LastID();
                
              //  System.out.println(">>"+lengthofid);
                if(lengthofid!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getLibrarianName)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                  //  System.out.println(">>>>"+dlm.toString());
                                }
                        }
                
                    
                     
                         adminFrontList.setModel(dlm);
                         //System.out.println(">>>>>>"+jList1);
                }
                else
                {
             //   JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No AdMin");
                adminFrontList.setModel(dlm);
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
                String getLibrarianName[]= gdfldbobj.getWNFromDB();
                int lengthofid=gdfldbobj.LastID();
                
              //  System.out.println(">>"+lengthofid);
                if(lengthofid!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getLibrarianName)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                  //  System.out.println(">>>>"+dlm.toString());
                                }
                        }
                
                    
                     
                         adminList.setModel(dlm);
                         //System.out.println(">>>>>>"+jList1);
                }
                else
                {
              //  JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                DefaultListModel dlm=new DefaultListModel();
                dlm.addElement("No AdMin");
                adminList.setModel(dlm);
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getRandomTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRandomTFActionPerformed
        
        
    }//GEN-LAST:event_getRandomTFActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        random();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Main object=new Main();
        object.setVisible(true);
        object.setLocationRelativeTo(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList adminFrontList;
    private javax.swing.JList adminInfoFrontList;
    private javax.swing.JList adminInformationList;
    private javax.swing.JList adminList;
    private javax.swing.JTextField caAddtf;
    private javax.swing.JButton caCancelButt;
    private javax.swing.JTextField caEmltf;
    private javax.swing.JTextField caNametf;
    private javax.swing.JTextField caOidtf;
    private javax.swing.JPasswordField caPwtf;
    private javax.swing.JTextField cac1tf;
    private javax.swing.JTextField cac2tf;
    private javax.swing.JButton createAccountOkButton;
    private javax.swing.JTextField getRandomTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logNameCancelButton;
    private javax.swing.JButton logNameOkbutton;
    private javax.swing.JTextField logNametf;
    private javax.swing.JPasswordField logPftf;
    private javax.swing.JLabel loggerLabel;
    private javax.swing.JLabel randomLabel;
    // End of variables declaration//GEN-END:variables
}

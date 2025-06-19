
package view;

import factories.DolGuldurBuilderFactory;
import factories.DolGuldurGearFactory;
import factories.GreyMountainsBuilderFactory;
import factories.GreyMountainsGearFactory;
import factories.MistyMountainsBuilderFactory;
import factories.MistyMountainsGearFactory;
import factories.MordorBuilderFactory;
import factories.MordorGearFactory;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import main.NamesOfTribes;
import main.OrkDirector;
import model.Ork;

/**
 *
 * @author elenagoncarova
 */
public class MainFrame extends JFrame implements ActionListener {
    OrkDirector mordorDirector;
    OrkDirector mistyMountainsDirector;
    OrkDirector greyMountainsDirector;
    OrkDirector dolGuldurDirector;
    private JComboBox tribeComboBox;
    private JComboBox roleComboBox;
    private JTextField nameTextField;
    private JTree tree;
    private ArmyTreeModel armyTreeModel = new ArmyTreeModel();

    public MainFrame() {
        mordorDirector = new OrkDirector(new MordorBuilderFactory(new MordorGearFactory()));
        mistyMountainsDirector = new OrkDirector(new MistyMountainsBuilderFactory(new MistyMountainsGearFactory()));
        greyMountainsDirector = new OrkDirector(new GreyMountainsBuilderFactory(new GreyMountainsGearFactory()));
        dolGuldurDirector = new OrkDirector(new DolGuldurBuilderFactory(new DolGuldurGearFactory()));
        setTitle("Армия");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 600, 430);

        tree = new JTree(armyTreeModel);
        tree.setBounds(15, 10, 245, 220);
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setBounds(15, 10, 255, 230);
        add(scrollPane);
        scrollPane.setViewportView(tree);

        JLabel nameLabel = new JLabel("");
        nameLabel.setBounds(280, 10, 270, 20);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JLabel tribeInfoLabel = new JLabel("");
        tribeInfoLabel.setBounds(280, 35, 270, 20);
        tribeInfoLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JLabel roleInfoLabel = new JLabel("");
        roleInfoLabel.setBounds(450, 35, 220, 20);
        roleInfoLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JLabel strengthLabel = new JLabel("");
        strengthLabel.setBounds(280, 60, 100, 20);
        strengthLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setBounds(400, 60, 150, 20);
        strengthBar.setVisible(false);
        
        JLabel agilityLabel = new JLabel("");
        agilityLabel.setBounds(280, 90, 270, 20);
        agilityLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JProgressBar agilityBar = new JProgressBar(0, 100);
        agilityBar.setBounds(400, 90, 150, 20);
        agilityBar.setVisible(false);
        
        JLabel healthLabel = new JLabel("");
        healthLabel.setBounds(280, 120, 270, 20);
        healthLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JProgressBar healthBar = new JProgressBar(0, 100);
        healthBar.setBounds(400, 120, 150, 20);
        healthBar.setVisible(false);
        
        JLabel weaponLabel = new JLabel("");
        weaponLabel.setBounds(280, 150, 270, 20);
        weaponLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JLabel armorLabel = new JLabel("");
        armorLabel.setBounds(280, 180, 270, 20);
        armorLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        JLabel bannerLabel = new JLabel("");
        bannerLabel.setBounds(280, 210, 270, 20);
        bannerLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        JButton createBtn = new JButton("Создать");
        createBtn.setBounds(10, 250, 120, 30);
        createBtn.addActionListener(this);
        createBtn.setActionCommand("create");

        JLabel tribeLabel = new JLabel("Племя");
        tribeLabel.setBounds(15, 290, 50, 20);
        tribeComboBox = new JComboBox<>(NamesOfTribes.TRIBES);
        tribeComboBox.setBounds(70, 290, 400, 25);
        tribeComboBox.setSelectedItem(null);
        
        JLabel roleLabel = new JLabel("Роль");
        roleLabel.setBounds(15, 320, 50, 20);
        roleComboBox = new JComboBox<>(new String[]{
                "Базовый",
                "Командир",
                "Разведчик",
        });
        roleComboBox.setBounds(70, 320, 400, 25);
        roleComboBox.setSelectedItem(null);
        
        JLabel nameFieldLabel = new JLabel("Имя");
        nameFieldLabel.setBounds(15, 350, 50, 20);
        nameTextField = new JTextField();
        nameTextField.setBounds(70, 350, 400, 25);

        add(nameLabel);
        add(tribeInfoLabel);
        add(roleInfoLabel);
        add(strengthLabel);
        add(strengthBar);
        add(agilityLabel);
        add(agilityBar);
        add(healthLabel);
        add(healthBar);
        add(weaponLabel);
        add(armorLabel);
        add(bannerLabel);

        add(createBtn);
        add(tribeLabel);
        add(tribeComboBox);
        add(roleLabel);
        add(roleComboBox);
        add(nameFieldLabel);
        add(nameTextField);

        setVisible(true);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object object = e.getPath().getLastPathComponent();

                if (object instanceof Ork) {
                    Ork ork = (Ork) object;
                    System.out.println(ork.getName());
                    nameLabel.setText("Имя: " + ork.getName());
                    tribeInfoLabel.setText("Племя: " + ork.getTribe());
                    roleInfoLabel.setText("Роль: " + ork.getRole());
                    strengthLabel.setText("Сила: " + ork.getStrength());
                    strengthBar.setValue(ork.getStrength());
                    strengthBar.setVisible(true);
                    agilityLabel.setText("Ловкость: " + ork.getAgility());
                    agilityBar.setValue(ork.getAgility());
                    agilityBar.setVisible(true);
                    healthLabel.setText("Здоровье: " + ork.getHealth());
                    healthBar.setValue((int) ((ork.getHealth() - 50) / 1.5));
                    healthBar.setVisible(true);
                    weaponLabel.setText("Оружие: " + ork.getWeapon());
                    armorLabel.setText("Броня: " + ork.getArmor());
                    if (ork.getBanner() != null) {
                        bannerLabel.setText("Знамя: " + ork.getBanner());
                    } else {
                        bannerLabel.setText("");
                    }
                } else {
                    nameLabel.setText("");
                    tribeInfoLabel.setText("");
                    roleInfoLabel.setText("");
                    strengthLabel.setText("");
                    strengthBar.setVisible(false);
                    agilityLabel.setText("");
                    agilityBar.setVisible(false);
                    healthLabel.setText("");
                    healthBar.setVisible(false);
                    weaponLabel.setText("");
                    armorLabel.setText("");
                    bannerLabel.setText("");
                }
            }
        });
    }

    private OrkDirector getDirectorByTribe(String tribe) {
        if (tribe.equals(NamesOfTribes.TRIBES[0])) {
            return this.mordorDirector;
        } else if (tribe.equals(NamesOfTribes.TRIBES[1])) {
            return this.dolGuldurDirector;
        } else if (tribe.equals(NamesOfTribes.TRIBES[2])) {
            return this.mistyMountainsDirector;
        } else if (tribe.equals(NamesOfTribes.TRIBES[3])) {
            return this.greyMountainsDirector;
        }

        return mordorDirector;
    }

    private Ork getOrkByRole(OrkDirector director, String role, String name) {
        if (role.equals("Базовый")) {
            return director.createBasicOrk(name);
        } else if (role.equals("Командир")) {
            return director.createLeaderOrk(name);
        } else if (role.equals("Разведчик")) {
            return director.createScoutOrk(name);
        }
        return director.createBasicOrk(name);
    }

    private void createOrk() {
        if (tribeComboBox.getSelectedItem() == null || roleComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Поля Племя и Роль обязательно должны быть заполнены, Имя опционально",
                    "Не заполнены поля!",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        String tribe = tribeComboBox.getSelectedItem().toString();
        String role = roleComboBox.getSelectedItem().toString();
        String name = nameTextField.getText();
        if (!name.trim().isEmpty()) {
            if (!name.matches("[a-zA-Zа-яА-Я]+")) {
                JOptionPane.showMessageDialog(
                    this,
                    "Имя не должно содержать цифры или знаки препинания",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        OrkDirector director = this.getDirectorByTribe(tribe);
        Ork newOrk = this.getOrkByRole(director, role, name);
        System.out.println("----------");
        System.out.println("Добавлен " + newOrk.getName());
        System.out.println("----------");
        armyTreeModel.addOrk(newOrk, tribe);
        String root = (String) armyTreeModel.getRoot();
        tree.expandPath(new TreePath(new Object[]{root, tribe}));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("exit")) {
            System.exit(0);
        }
        if (command.equals("create")) {
            createOrk();
        }
    }
}

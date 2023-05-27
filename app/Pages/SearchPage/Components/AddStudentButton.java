package Pages.SearchPage.Components;

import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import Components.Button;
import Pages.Manager;

/**
 * A class for creating buttons.
 */
public class AddStudentButton extends Button {
  /**
   * Constructs a new NewStudentButton object and adds it to the search page
   * canvas.
   *
   * @param manager the manager to use for adding the button to the search page
   *                canvas
   */
  public AddStudentButton(Manager manager) {
    super("Add Student", 250, 100);
    super.setSize(120, 30);
    super.addActionListener(e -> this.onClick(manager));
    manager.searchPage.add(this);
  }

  /**
   * Handles the button click event.
   */
  public void onClick(Manager manager) {
      Object res = this.getNameDialog();
      if (clickedCancel(res)) {
        return;
      }
      
      // Try adding the student to the cache
      try {
        manager.cache.addStudent((String) res);
      } catch (NoSuchAlgorithmException err) {
        this.errorDialog();
      }
    }

  /**
   * Displays an invalid name dialog.
   */
  public void invalidNameDialog() {
    JOptionPane.showMessageDialog(this,
        "Please enter a valid name.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Displays an error dialog.
   */
  public void errorDialog() {
    JOptionPane.showMessageDialog(this,
        "An error occurred while adding the student.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Gets the name dialog.
   *
   * @return the name dialog result
   */
  public Object getNameDialog() {
    // Pop up dialog to get the student's name (first and last)
    return JOptionPane.showInputDialog(this,
        "Enter the student's name (last; first):",
        "Add Student",
        JOptionPane.PLAIN_MESSAGE);
  }

  /**
   * Checks if the cancel button was clicked.
   *
   * @param res the result of the dialog
   * @return true if the cancel button was clicked, false otherwise
   */
  public boolean clickedCancel(Object res) {
    return res == null;
  }
}

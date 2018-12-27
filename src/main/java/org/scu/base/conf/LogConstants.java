package org.scu.base.conf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public class LogConstants {

  public static final String SPLITOR_MODULE_ACTION = "-";

  public static class User {

    public static final String MODULE = "user";

    public static final String ACTION_LOGIN = "login";

    public static final String ACTION_MODIFY_PASSWORD = "modify_password";
  }

  public static class Company extends BaseAction {

    public static final String MODULE = "company";
  }

  public static class Product extends BaseAction {

    public static final String MODULE = "product";
  }

  public static class Clients extends BaseAction {

    public static final String MODULE = "clients";
  }

  public static class BaseAction {

    public static final String ACTION_INSERT = "insert";

    public static final String ACTION_DELETE = "delete";

    public static final String ACTION_UPDATE = "update";
  }

  public static final List<ModuleAction> moduleActionList = new ArrayList<>();

  static {
    moduleActionList.add(newUserModule());
    moduleActionList.add(newCompanyModule());
    moduleActionList.add(newProductModule());
    moduleActionList.add(newClientModule());
  }

  public static ModuleAction newUserModule() {
    ModuleAction user = new ModuleAction();
    List<ValueLabel> options = new ArrayList<>();
    options.add(new ValueLabel(User.MODULE + SPLITOR_MODULE_ACTION + User.ACTION_LOGIN, "登录"));
    options.add(new ValueLabel(User.MODULE + SPLITOR_MODULE_ACTION + User.ACTION_MODIFY_PASSWORD,
                               "修改密码"));
    user.setLabel("用户");
    user.setOptions(options);
    return user;
  }

  public static ModuleAction newCompanyModule() {
    ModuleAction module = new ModuleAction();
    List<ValueLabel> options = new ArrayList<>();
    options.add(new ValueLabel(Company.MODULE + SPLITOR_MODULE_ACTION + Company.ACTION_DELETE,
                               "删除"));
    options.add(new ValueLabel(Company.MODULE + SPLITOR_MODULE_ACTION + Company.ACTION_INSERT,
                               "添加"));
    options.add(new ValueLabel(Company.MODULE + SPLITOR_MODULE_ACTION + Company.ACTION_UPDATE,
                               "编辑"));
    module.setLabel("公司");
    module.setOptions(options);
    return module;
  }

  public static ModuleAction newProductModule() {
    ModuleAction module = new ModuleAction();
    List<ValueLabel> options = new ArrayList<>();
    options.add(new ValueLabel(Product.MODULE + SPLITOR_MODULE_ACTION + Product.ACTION_DELETE,
                               "删除"));
    options.add(new ValueLabel(Product.MODULE + SPLITOR_MODULE_ACTION + Product.ACTION_INSERT,
                               "添加"));
    options.add(new ValueLabel(Product.MODULE + SPLITOR_MODULE_ACTION + Product.ACTION_UPDATE,
                               "编辑"));
    module.setLabel("产品");
    module.setOptions(options);
    return module;
  }

  public static ModuleAction newClientModule() {
    ModuleAction module = new ModuleAction();
    List<ValueLabel> options = new ArrayList<>();
    options.add(new ValueLabel(Clients.MODULE + SPLITOR_MODULE_ACTION + Clients.ACTION_DELETE,
                               "删除"));
    options.add(new ValueLabel(Clients.MODULE + SPLITOR_MODULE_ACTION + Clients.ACTION_INSERT,
                               "添加"));
    options.add(new ValueLabel(Clients.MODULE + SPLITOR_MODULE_ACTION + Clients.ACTION_UPDATE,
                               "编辑"));
    module.setLabel("客户");
    module.setOptions(options);
    return module;
  }
}

class ModuleAction {

  private String label;

  private List<ValueLabel> options;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public List<ValueLabel> getOptions() {
    return options;
  }

  public void setOptions(List<ValueLabel> options) {
    this.options = options;
  }
}

class ValueLabel {

  private String label;

  private String value;

  public ValueLabel(String value, String label) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

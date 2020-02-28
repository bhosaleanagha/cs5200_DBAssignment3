package edu.northeastern.cs5200.models;

public class Widget
{
  private int id;
  private String name;
  private int width;
  private int height;
  private String url;
  private String cssClass;
  private String cssStyle;
  private String text;
  private int sequence;
  private boolean shareable;
  private boolean expandable;
  private String src;
  private int size;
  private int pageid;

  public Widget(){

  }
  public boolean isShareable() {
    return shareable;
  }

  public boolean isExpandable() {
    return expandable;
  }

  public int getPageid() {
    return pageid;
  }

  public void setPageid(int pageid) {
    this.pageid = pageid;
  }




  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public void setDtype(String dtype) {
    this.dtype = dtype;
  }

  private String html;
  private String dtype;

  public Widget(int id,String name,int width, int height,String cssStyle,String cssClass, String text,
      int sequence){
    this.id = id;
    this.name = name;
    this.width= width;
    this.height= height;
    this.cssStyle = cssStyle;
    this.cssClass= cssClass;
    this.text= text;
    this.sequence= sequence;
  }

  public Widget(int id,String name,int width, int height,String cssStyle,String cssClass, String text,
      int sequence,int size,String html, String src,String url,boolean shareable, boolean expandable,
      String dtype){
    this.id = id;
    this.name = name;
    this.width= width;
    this.height= height;
    this.cssStyle = cssStyle;
    this.cssClass= cssClass;
    this.text= text;
    this.sequence= sequence;
    this.size = size;
    this.html = html;
    this.src = src;
    this.url= url;
    this.shareable = shareable;
    this.expandable = expandable;
    this.dtype= dtype;
  }
  public boolean getShareable() {
    return shareable;
  }

  public void setShareable(boolean shareable) {
    this.shareable = shareable;
  }

  public boolean getExpandable() {
    return expandable;
  }

  public void setExpandable(boolean expandable) {
    this.expandable = expandable;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getCssStyle() {
    return cssStyle;
  }

  public void setCssStyle(String cssStyle) {
    this.cssStyle = cssStyle;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getDtype() {
    return dtype;
  }
}

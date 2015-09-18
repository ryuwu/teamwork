package actionPackage;
import infoPackage.CustomerInfo;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.CustomerManagementDao;

/**
 * 顧客の情報をリストとして表示するアクションクラス
 *
 * @author	周平
 * @date	2015/09/18
 * @version	1.0
 *
 * @author	kiku
 * @date	2015/09/18
 * @version	1.1
 *
 * 修正履歴：
 * ① プロパティの名前を修正した。 result1 -> viewResult
 *
 */
public class CustomerViewAction extends ActionSupport{

	//顧客の情報をHTMLのリストにまとめる。
	private String result1 = "";

	public String getResult1() {
		return result1;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}

	/**
	 * 顧客の情報抽出メソッドである。
	 * 顧客の情報をDaoから取り出して、HTMLのリストにまとめる。
	 *
	 * @return String 画面遷移のキーワード
	 */
	public String execute() throws Exception{

		//Daoを使って、すべての顧客の情報を取り出す。
		CustomerManagementDao dao = CustomerManagementDao.getInstance();
		List<CustomerInfo> result = dao.getUserInfos();

		//HTMLのテーブルのタイトルを表示する。
		this.result1 += "<table border=\"1\"><tr><th>会社の名前</th><th>会社のE-mail</th><th>住所</th><th>更新</th></tr>";

		//Daoから取り出された顧客のリストから情報を出して、HTMLのテーブルに保存する。
		for(CustomerInfo userInfo:result) {

			//この行の開始
			this.result1 += "<tr>";

			//この行の第一項目に顧客の会社名を設定する。
			this.result1 += "<td>" + userInfo.getUserName() + "</td>";

			//この行の第二項目に顧客のEメールを設定する。
			this.result1 += "<td>" + userInfo.getEmail() + "</td>";

			//この行の第三項目に顧客の住所を設定する。
			this.result1 += "<td>" + userInfo.getAddress() + "</td>";

			//この行の第四項目に顧客の更新フォームを設定する。
			this.result1 += "<td>" + "<form id=\"updateUser\" " + "name=\"updateUser\" " + "action=\"updateUser.action\" method=\"post\" >" +
				//隠されたuserNameフィールドにこの行に対応してる顧客の会社名を設定する。
				"<input type=\"hidden\" name=\"userName\" value=\"" + userInfo.getUserName()+ "\" id=\"updateUser_userName\"  />"+
				//隠されたemailフィールドにこの行に対応してる顧客のEメールを設定する。
				"<input type=\"hidden\" name=\"email\" value=\"" + userInfo.getEmail()+ "\" id=\"updateUser_email\"  />"+
				//隠されたaddressフィールドにこの行に対応してる顧客の住所を設定する。
				"<input type=\"hidden\" name=\"address\" value=\"" + userInfo.getAddress()+ "\" id=\"updateUser_address\"  />"+
				//サブミットボタンを設定する。
				"<input type=\"submit\" id=\"updateUser\" value=\"変更\" />"+
				"</form>"+
				"</td>";

			//この行の終了
			this.result1 += "</tr>";
		}

		return "success";

	}

}
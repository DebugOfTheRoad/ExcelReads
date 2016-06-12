package seven.wapperInt;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

//=======================================================
//		          .----.
//		       _.'__    `.
//		   .--(^)(^^)---/#\
//		 .' @          /###\
//		 :         ,   #####
//		  `-..__.-' _.-\###/
//		        `;_:    `"'
//		      .'"""""`.
//		     /,  ya ,\\
//		    //狗神保佑  \\
//		    `-._______.-'
//		    ___`. | .'___
//		   (______|______)
//=======================================================
/**
 * @author Seven<p>
 * @date   2016年4月12日-下午4:08:08
 */
public abstract class Wapper {
	protected Config config;
	protected DecimalFormat df = new DecimalFormat("0");
	protected String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				cellvalue = df.format(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_FORMULA: {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);
				} else {
					cellvalue = String.valueOf(cell.getStringCellValue());
				}
				break;
			}
			case HSSFCell.CELL_TYPE_BLANK:
				cellvalue = " ";
				break;
			case HSSFCell.CELL_TYPE_STRING:
				cellvalue = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				cellvalue = " ";
				break;
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}
	protected void LoadConfig(Config config) {
		this.config = config;
	};
	protected abstract Config LoadConfig();
	public Wapper() {
		config = LoadConfig();
	}
	public class Config {
		Integer title_row = null;
		Integer content_row_start = null;
		Integer content_row_end = null;
		Boolean is_loop_sheet = false;
		Boolean error_log = true;
		Integer Voc_size = 10000;
		String Require[] = null;
		Integer start_sheet = 0;
		Integer end_sheet = null;

		public Config() {
		}

		public String[] getRequire() {
			return Require;
		}

		/**
		 * Map数据个校验数组
		 * <p>
		 * 支持正则表达式
		 * 
		 * @see seven.wapperInt.anno.RegHelper
		 * @return
		 */
		public void setRequire(String[] require) {
			Require = require;
		}

		public Integer getVoc_size() {
			return Voc_size;
		}

		/**
		 * Excel数据容器<br>
		 * 当数据大于5w时，最好初始化为大于或者等于当前excel行数 最好设置大于或者
		 * 
		 * @param voc_size
		 */
		public void setVoc_size(Integer voc_size) {
			Voc_size = voc_size;
		}

		public Boolean getError_log() {
			return error_log;
		}

		public void setError_log(Boolean error_log) {
			this.error_log = error_log;
		}

		public Config(Integer title_row, Integer content_row_start, Integer content_row_end) {
			super();
			this.title_row = title_row;
			this.content_row_start = content_row_start;
			this.content_row_end = content_row_end;
		}

		/**
		 * 内容开始行号
		 * 
		 * @param content_row_start
		 */
		public Integer getTitle_row() {
			return title_row;
		}

		/**
		 * 标题行号
		 * 
		 * @param content_row_start
		 */
		public void setTitle_row(Integer title_row) {
			this.title_row = title_row;
		}

		/**
		 * 内容开始行号
		 * 
		 * @param content_row_start
		 */
		public Integer getContent_row_start() {
			return content_row_start;
		}

		/**
		 * 内容开始行号
		 * 
		 * @param content_row_start
		 */
		public void setContent_row_start(Integer content_row_start) {
			this.content_row_start = content_row_start;
		}

		/**
		 * 内容结束行号
		 * 
		 * @param content_row_start
		 */
		public Integer getContent_row_end() {
			return content_row_end;
		}

		/**
		 * 内容结束行号
		 * 
		 * @param content_row_start
		 */
		public void setContent_row_end(Integer content_row_end) {
			this.content_row_end = content_row_end;
		}

		public Boolean getIs_loop_sheet() {
			return is_loop_sheet;
		}

		public void setIs_loop_sheet(Boolean is_loop_sheet) {
			this.is_loop_sheet = is_loop_sheet;
		}

		public Integer getStart_sheet() {
			return start_sheet;
		}

		public void setStart_sheet(Integer start_sheet) {
			this.start_sheet = start_sheet;
		}

		public Integer getEnd_sheet() {
			return end_sheet;
		}

		public void setEnd_sheet(Integer end_sheet) {
			this.end_sheet = end_sheet;
		}

	}
}

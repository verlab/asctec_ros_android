package asctec_hl_comm;

public interface MavCtrlSrvResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_hl_comm/MavCtrlSrvResponse";
  static final java.lang.String _DEFINITION = "mav_ctrl ctrl_result";
  asctec_hl_comm.mav_ctrl getCtrlResult();
  void setCtrlResult(asctec_hl_comm.mav_ctrl value);
}

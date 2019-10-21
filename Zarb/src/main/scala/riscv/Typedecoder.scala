package riscv
import chisel3._
class Typedecoder extends Module{
val io=IO(new Bundle{
	val opcode=Input(UInt(7.W))
	val R_type=Output(UInt(1.W))
	val load=Output(UInt(1.W))
	val store=Output(UInt(1.W))
	val branch=Output(UInt(1.W))
	val I_type=Output(UInt(1.W))
	val jalr=Output(UInt(1.W))
	val jal=Output(UInt(1.W))
	val lui=Output(UInt(1.W))
})
	when(io.opcode==="h33".U){
		io.R_type:="b1".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h03".U){
		io.R_type:="b0".U
		io.load:="b1".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h23".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b1".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h63".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b1".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h13".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b1".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h67".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b1".U
		io.jal:="b0".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h6f".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b1".U
		io.lui:="b0".U
	}.elsewhen(io.opcode==="h37".U){
		io.R_type:="b0".U
		io.load:="b0".U
		io.store:="b0".U
		io.branch:="b0".U
		io.I_type:="b0".U
		io.jalr:="b0".U
		io.jal:="b0".U
		io.lui:="b1".U
	}.otherwise{
		io.R_type:=DontCare
		io.load:=DontCare
		io.store:=DontCare
		io.branch:=DontCare
		io.I_type:=DontCare
		io.jalr:=DontCare
		io.jal:=DontCare
		io.lui:=DontCare
	}
	
}

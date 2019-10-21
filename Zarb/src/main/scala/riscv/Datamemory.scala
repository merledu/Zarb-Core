package riscv
import chisel3._
class Datamemory extends Module{
val io=IO(new Bundle{
	val in_Aluoutput=Input(UInt(8.W))
	val in_rs2out=Input(SInt(32.W))
	val in_controlmemwrite=Input(UInt(1.W))
	val in_controlmemread=Input(UInt(1.W))
	val out_datamemory=Output(SInt(32.W))
})
	val mem=Mem(1024,SInt(32.W))
	when (io.in_controlmemwrite==="b1".U){
		mem(io.in_Aluoutput):=io.in_rs2out
	}.otherwise{
		io.out_datamemory:=DontCare
	}
	when(io.in_controlmemread==="b1".U){
		io.out_datamemory:=mem(io.in_Aluoutput)
		
	}.otherwise{
		io.out_datamemory:=DontCare
	}
			
}

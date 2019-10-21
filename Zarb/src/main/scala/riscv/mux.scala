package riscv
import chisel3._
class Mux extends Module{
val io=IO(new Bundle{
	val i0=Input(UInt(1.W))
	val i1=Input(UInt(1.W))
	val s0=Input(UInt(1.W))
	val o=Output(UInt(1.W))
})
	io.o:= (io.i1&io.s0)|(io.i0&(~io.s0))
}

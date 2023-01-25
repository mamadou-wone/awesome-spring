#include "Enclave_u.h"
#include <errno.h>

typedef struct ms_trusted_func01_t {
	int ms_retval;
} ms_trusted_func01_t;

typedef struct ms_ocall_wait_keyinput_t {
	const char* ms_str;
} ms_ocall_wait_keyinput_t;

static sgx_status_t SGX_CDECL Enclave_ocall_wait_keyinput(void* pms)
{
	ms_ocall_wait_keyinput_t* ms = SGX_CAST(ms_ocall_wait_keyinput_t*, pms);
	ocall_wait_keyinput(ms->ms_str);

	return SGX_SUCCESS;
}

static const struct {
	size_t nr_ocall;
	void * table[1];
} ocall_table_Enclave = {
	1,
	{
		(void*)Enclave_ocall_wait_keyinput,
	}
};
sgx_status_t trusted_func01(sgx_enclave_id_t eid, int* retval)
{
	sgx_status_t status;
	ms_trusted_func01_t ms;
	status = sgx_ecall(eid, 0, &ocall_table_Enclave, &ms);
	if (status == SGX_SUCCESS && retval) *retval = ms.ms_retval;
	return status;
}


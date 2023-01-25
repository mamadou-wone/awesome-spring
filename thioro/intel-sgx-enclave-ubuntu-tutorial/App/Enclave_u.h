#ifndef ENCLAVE_U_H__
#define ENCLAVE_U_H__

#include <stdint.h>
#include <wchar.h>
#include <stddef.h>
#include <string.h>
#include "sgx_edger8r.h" /* for sgx_status_t etc. */


#include <stdlib.h> /* for size_t */

#define SGX_CAST(type, item) ((type)(item))

#ifdef __cplusplus
extern "C" {
#endif

#ifndef OCALL_WAIT_KEYINPUT_DEFINED__
#define OCALL_WAIT_KEYINPUT_DEFINED__
void SGX_UBRIDGE(SGX_NOCONVENTION, ocall_wait_keyinput, (const char* str));
#endif

sgx_status_t trusted_func01(sgx_enclave_id_t eid, int* retval);

#ifdef __cplusplus
}
#endif /* __cplusplus */

#endif

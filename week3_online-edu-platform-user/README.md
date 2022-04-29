### USER

<details>
  <summary>
    <code>POST</code> 
    <code><b>/users/register</b></code> 
    <code>(강사회원 생성)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `name` |  String  | 이름     | O |
> | `email` |  String  | 이메일     | O |
> | `password` | String | 비밀번호 | O |
> | `email` |  String  | 이메일     | O |
> | `address` |  String  | 주소     |  |
> | `phone` |  String  | 전화번호     |  |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `userId` |  Integer  | 강사회원 ID     | O |

</details>



<details>
  <summary>
    <code>POST</code> 
    <code><b>/users/join</b></code>
    <code>(학생회원 가입)</code>
  </summary>

##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `name` |  String  | 이름     | O |
> | `email` |  String  | 이메일     | O |
> | `password` | String | 비밀번호 | O |
> | `address` |  String  | 주소     |  |
> | `phone` |  String  | 전화번호     |  |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `userId` |  Integer  | 학생회원 ID     | O |


</details>


<details>
  <summary>
    <code>POST</code> 
    <code><b>/users/login</b></code> 
    <code>(회원 로그인)</code>
  </summary>

##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `email` |  String  | 이메일     | O |
> | `password` |  String  | 비밀번호     | O |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `token_type` |  string  | 토큰 타입     | O |
> | `access_token` |  string  | 사용자 액세스 토큰 값     | O |
> | `expires_in` |  Integer  | 토큰 만료 시간     | O |

</details>

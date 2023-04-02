// @ts-ignore
/* eslint-disable */

declare namespace SYSTEM {
  type Page<T> = {
    code: number;
    count: number;
    data: T[];
  };

  type Role = {
    id: number;
    createTime?: Date;
    updateTime?: Date;
    code: string;
    name: string;
    userId?: string;
  };

  type User = {
    id?: number;
    userName?: string;
    userAccount?: string;
    password?: string;
    mobile?: string;
    createTime?: Date;
    status?: boolean;
    roles?: Role[];
    roleId?: number;
  };

  type Menu = {
    id: number;
    name?: string;
    pId?: number;
    parentId?: number;
    url?: string;
    type?: number;
    css?: string;
    checked?: boolean;
    open?: boolean;
    sort?: number;
    children?: Menu[];
  };

  type AssignMenu = {
    roleId: number;
    menuIds: (string|number)[];
  };

  type Token = {
    accountType?: string;
    clientId?: string;
    expiration?: Date;
    grantType?: string;
    tokenValue: string;
    username?: string;
  };

  type App = {
    id?: number;
    accessTokenValiditySeconds?: number;
    additionalInformation?: string;
    authorities?: string;
    authorizedGrantTypes?: string;
    autoapprove?: string;
    clientId: string;
    clientName?: string;
    clientSecret?: string;
    clientSecretStr?: string;
    createTime?: Date;
    idTokenValiditySeconds?: number;
    refreshTokenValiditySeconds?: number;
    resourceIds?: string;
    scope?: string;
    supportIdToken?: boolean;
    updateTime?: Date;
    webServerRedirectUri?: string;
  };

  type Generator = {
    createTime?: Date;
    engine?: string;
    tableComment?: string;
    tableName?: string;
  };

  type FileInfo = {
    id: string;
    name?: string;
    isImg: boolean;
    url?: string;
    contentType?: string;
    size?: number;
    path?: string;
    source?: string;
    createTime?: string;
    tenantId?: string;
    updateTime?: string;
  }
}

declare namespace API{
  type Result<T> = {
    code?: number;
    msg?: String;
    data?: T;
  }
}
